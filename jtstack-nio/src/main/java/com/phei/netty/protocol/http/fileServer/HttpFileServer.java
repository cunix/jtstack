package com.phei.netty.protocol.http.fileServer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

public class HttpFileServer {

	private static final String DEFAULT_URL = "/src/com/phei/netty/";

	public void run(final int port, final String url) throws Exception {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							// http请求消息解码器
							ch.pipeline().addLast("http-decoder", new HttpRequestDecoder());
							// httpObjectAggregator解码器，它的作用是将多个消息转换为单一的FullHttpRequest或者FullHttpResponse,HTTP解码器在每个HTTP消息中会生成多个消息对象
							// 1.HttpRequest /HttpResponse
							// 2.HttpContent
							// 3.LastHttpContent
							ch.pipeline().addLast("http-aggregator", new HttpObjectAggregator(65536));
							// http响应编码器,对响应消息进行编码
							ch.pipeline().addLast("http-encoder", new HttpResponseEncoder());
							// ChunkedHandler,支持异步发送大的码流(大文件传输)，但不占用更多的内存，防止虚拟机内存溢出
							ch.pipeline().addLast("http-chunked", new ChunkedWriteHandler());
							// 处理逻辑
							ch.pipeline().addLast("fileServerHandler", new HttpFileServerHandler(url));
						}
					});
			ChannelFuture future = b.bind("192.168.1.102", port).sync();
			System.out.println("HTTP文件目录服务器启动，网址是 : " + "http://192.168.1.102:" + port + url);
			future.channel().closeFuture().sync();
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}

	public static void main(String[] args) throws Exception {
		int port = 8080;
		if (args.length > 0) {
			try {
				port = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		String url = DEFAULT_URL;
		if (args.length > 1)
			url = args[1];
		new HttpFileServer().run(port, url);
	}
}

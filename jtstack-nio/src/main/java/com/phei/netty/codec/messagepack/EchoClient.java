package com.phei.netty.codec.messagepack;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class EchoClient {

	private final String host;
	private final int port;
	private final int sendNumber;

	public EchoClient(String host, int port, int sendNumber) {
		super();
		this.host = host;
		this.port = port;
		this.sendNumber = sendNumber;
	}

	public void run() throws Exception {
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			Bootstrap b = new Bootstrap();
			b.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true)
					.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3000).handler(new ChannelInitializer<Channel>() {
						@Override
						protected void initChannel(Channel channel) throws Exception {
							channel.pipeline().addLast("hello netty msgpack decoder", new MsgPackDecoder());
							channel.pipeline().addLast("hello netty msgpack encoder", new MsgPackEncoder());
							channel.pipeline().addLast(new EchoClientHandler(sendNumber));
						}
					});

			ChannelFuture f = b.connect(host, port).sync();
			f.channel().closeFuture().sync();
		} catch (Exception e) {
		} finally {
			group.shutdownGracefully();
		}
	}

}

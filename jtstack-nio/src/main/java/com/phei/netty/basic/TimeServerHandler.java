package com.phei.netty.basic;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class TimeServerHandler extends ChannelHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		//ByteBuf ==ByteBuffer
		ByteBuf buf = (ByteBuf) msg;
		//readableBytes方法可以缓冲区可读的字节数，根据可读的字节数创建byte数组
		byte[] req = new byte[buf.readableBytes()];
		//readBytes方法讲缓冲区可读的字节数复制到新建的byte数组中
		buf.readBytes(req);
		//最后根据new String()构造函数获取请求信息
		String body = new String(req, "UTF-8");
		System.out.println("The time server receive order : " + body);
		String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new java.util.Date(System.currentTimeMillis()).toString() : "BAD ORDER";
		ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
		//通过ChannelHandlerContext的write方法异步发送应答消息给客户端
		ctx.write(resp);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		//将消息发送队列中的消息写入到SocketChannel中发送给对方
		//从性能角度考虑，为了防止频繁的唤醒Selector进行消息发送，netty的write方法并不是直接将消息写入SocketChannel中，
		//调用write方法只是把待发送的消息放到发送缓冲数组中，在通过flush方法，讲发送缓冲区中的消息全部写到SocketChannel中
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		//当发生异常时，关闭ChannelHandlerContext,释放和ChannelHandlerContext相关联的句柄资源。
		ctx.close();
	}
}

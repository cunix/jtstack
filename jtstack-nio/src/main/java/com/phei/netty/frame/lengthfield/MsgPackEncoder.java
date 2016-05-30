package com.phei.netty.frame.lengthfield;


import org.msgpack.MessagePack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;


public class MsgPackEncoder extends MessageToByteEncoder<Object>{

	@Override
	protected void encode(ChannelHandlerContext arg0, Object arg1, ByteBuf arg2) throws Exception {
		MessagePack msgpack=new MessagePack();
		byte[] write = msgpack.write(arg1);
		arg2.writeBytes(arg2);
	}
}

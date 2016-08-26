package com.phei.netty.api.bytebuffer;

import java.nio.ByteBuffer;

public class ByteBufAPI {

	
	public static void main(String[] args) {
		ByteBuffer bb=ByteBuffer.allocate(88);
		bb.put("Netty权威指南".getBytes());
		bb.flip();
		byte[] array=new byte[bb.remaining()];
		bb.get(array);
		String decodeValue=new String(array);
		System.out.println(decodeValue);
	}
}

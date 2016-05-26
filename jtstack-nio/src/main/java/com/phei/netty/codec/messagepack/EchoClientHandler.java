package com.phei.netty.codec.messagepack;


import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class EchoClientHandler extends ChannelHandlerAdapter {

	private final int sendNumber;

	public EchoClientHandler(int sendNumber) {
		super();
		this.sendNumber = sendNumber;
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		UserInfo[] infos=userInfo();
		for (UserInfo userInfo : infos) {
			ctx.write(userInfo);
		}
		ctx.flush();
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("Client receive the msgpack message:"+msg);
		ctx.write(msg);
	}
	
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}
	
	public UserInfo[] userInfo(){
		UserInfo[] userInfos=new UserInfo[sendNumber];
		UserInfo userInfo=null;
		for (int i = 0; i < sendNumber; i++) {
			UserInfo u=new UserInfo();
			u.setAge(i);
			u.setName("ABCDEFG--->"+i);
			userInfos[i]=u;
		}
		return userInfos;
	}
	
	
	
	
	
	
}

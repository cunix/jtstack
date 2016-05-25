package com.phei.netty.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.List;
import java.util.Set;

public class NioServerApi {

	
	public static void main(String[] args) throws IOException {
		//步骤一:打开ServerSocketChannel,用于监听客户端的连接,他是所有客户端连接的父管道
		ServerSocketChannel acceptorSrv=ServerSocketChannel.open();
		//步骤二:绑定监听端口设置为非阻塞模式
		acceptorSrv.socket().bind(new InetSocketAddress(InetAddress.getByName("IP"), 8080));
		acceptorSrv.configureBlocking(false);
		//步骤三:创建Reactor线程,创建多路复用器并启动线程
		Selector selector=Selector.open();
		new Thread(new ReactorTask()).start();
		Object ioHandler = null;
		//步骤四:将ServerSocketChannel注册到Reactor线程的多路复用器Selector上,监听accept事件,代码如下
		SelectionKey key=acceptorSrv.register(selector, SelectionKey.OP_ACCEPT, ioHandler);
		///步骤五:多路复用器在线程Run方法的无限循环体内轮询准备就绪的key
		int num=selector.select();
		Set<SelectionKey> selectedKeys = selector.selectedKeys();
		for (SelectionKey selectionKey : selectedKeys) {
			//deal with I/O event
		}
		//步骤六:多路复用器监听到有新的客户端接入,处理新的接入请求,完成TCP三次握手,建立物理链路
		SocketChannel accept = acceptorSrv.accept();
		
		//步骤七:设置客户端链路为非阻塞模式
		accept.configureBlocking(false);
		accept.socket().setReuseAddress(true);
		//步骤八:将新接入的客户端连接注册到Reactor线程的多路复用器上,监听读写操作,用来读取客户端发送的网络消息
		accept.register(selector, SelectionKey.OP_ACCEPT, ioHandler);
		//步骤九:异步读取客户端请求消息缓冲区
		ByteBuffer dst = null;
		int read = accept.read(dst);
		//步骤十:对ByteBuffer进行编解码,如果有半包消息指针reset,继续读取后续的报文,将解码成功的消息封装成task,投递到业务线程池中,进行业务逻辑编排
		Object message=null;
		List messageList = null;
		while(dst.hasRemaining()){
			dst.mark();
			Object msg=decode(dst);
			if(msg==null){
				dst.reset();
				break;
			}
			messageList.add(msg);
			if(!dst.hasRemaining()){
				dst.clear();
			}else{
				dst.compact();
			}
		}
		//步骤十一:将POJO对象encode成ByteBuffer,调用SocketChannel的异步write接口,将消息发送给客户端
		accept.write(dst);
		/**
		 * 注意:如果发送区TCP缓冲区满,会导致写半包,此时需要监听写操作位,循环写,直到整包消息写入到TCP缓冲区,此处不再赘述,后续Netty源码分析章节会详细分析Netty的处理策略
		 */

		
	}

	private static Object decode(ByteBuffer dst) {
		// TODO Auto-generated method stub
		return null;
	}
}

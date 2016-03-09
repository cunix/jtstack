package com.jtstack.webservice.demo1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WeatherServerThread {
	public static void main(String[] args) throws IOException {
		// 创建socket服务端对象
		ServerSocket serverSocket = new ServerSocket(1234);
		System.out.println("服务端已启动。。。。");
		while (true) {
			// 监听客户端连接，accept方法为阻塞方法
			Socket socket = serverSocket.accept();
			new Thread(new WeatherRunnable(socket)).start();
		}
	}
}

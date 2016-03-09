package com.jtstack.webservice.demo1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WeatherServer {
	public static void main(String[] args) throws IOException {
		// 创建socket服务端对象
		ServerSocket serverSocket = new ServerSocket(1234);
		System.out.println("服务端已启动。。。。");
		while (true) {
			// 监听客户端连接，accept方法为阻塞方法
			Socket socket = serverSocket.accept();
			// 获取输入流准备获取客户端发送的数据
			DataInputStream dataInputStream = null;
			DataOutputStream dataOutputStream = null;
			try {
				// 包括为datainputstream
				dataInputStream = new DataInputStream(socket.getInputStream());
				// 读取数据
				String in_data = dataInputStream.readUTF();
				// 打印读取的数据
				System.out.println("from client.." + in_data);
				// 创建输出流准备输出数据
				dataOutputStream = new DataOutputStream(socket.getOutputStream());
				System.out.println("to client..." + "晴朗");
				dataOutputStream.writeUTF("晴朗");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// 释放资源
				if (dataOutputStream != null) {
					dataOutputStream.close();
				}
				if (dataInputStream != null) {
					dataInputStream.close();
				}
			}
		}
	}
}

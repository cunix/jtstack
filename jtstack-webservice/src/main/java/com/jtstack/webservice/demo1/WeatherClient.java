package com.jtstack.webservice.demo1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class WeatherClient {

	public static void main(String[] args) throws UnknownHostException,
			IOException {
		while (true) {
			// socket客户端对象
			Socket socket = null;
			// 输出流用于发送数据
			DataOutputStream dataOutputStream = null;
			// 输入流用于接收数据
			DataInputStream dataInputStream = null;
			try {
				// 创建socket
				socket = new Socket("127.0.0.1", 1234);
				socket.setSoTimeout(10000);// 超时时间为10秒，防止服务端处理超时返回数据失败
				// 创建输出流准备向服务端发送数据
				dataOutputStream = new DataOutputStream(
						socket.getOutputStream());
				dataOutputStream.writeUTF("郑州");
				System.out.println("to server...." + "郑州");
				// 接收服务端发送的数据
				dataInputStream = new DataInputStream(socket.getInputStream());
				String resultString = dataInputStream.readUTF();
				System.out.println("from server..." + resultString);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// 释放资源
				if (socket != null) {
					socket.close();
				}
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

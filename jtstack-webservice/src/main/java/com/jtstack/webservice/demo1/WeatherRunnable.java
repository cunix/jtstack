package com.jtstack.webservice.demo1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 
 * @author Administrator
 *
 */
public class WeatherRunnable implements Runnable {
	private Socket socket;

	public WeatherRunnable(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		// 获取输入流准备取客户端发送的数据
		DataInputStream dataInputStream = null;
		DataOutputStream dataOutputStream = null;
		try {
			// 包括为datainputstream
			dataInputStream = new DataInputStream(socket.getInputStream());
			// 读取数据
			String in_data = dataInputStream.readUTF();
			// 打印读取的数据
			System.out.println("from client.." + in_data);
			// 休眠3秒表示处理数据
			Thread.sleep(3000);
			// 创建输出流准备输出数据
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
			System.out.println("to client..." + "晴朗");
			dataOutputStream.writeUTF("晴朗");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			if (dataOutputStream != null) {
				try {
					dataOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (dataInputStream != null) {
				try {
					dataInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

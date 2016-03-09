package com.jtstack.webservice.demo2;

public class WeatherClient {
	public static void main(String[] args) {
		// 创建服务视图（？？）
		WeatherInterfaceImplService weatherInterfaceImplService = new WeatherInterfaceImplService();
		// 通过服务视图得到服务端点
		WeatherInterfaceImpl weatherInterfaceImpl = weatherInterfaceImplService
				.getPort(WeatherInterfaceImpl.class);
		// 调用webservice服务方法
		String result = weatherInterfaceImpl.queryWeather("郑州");
		System.out.println(result);
	}
}

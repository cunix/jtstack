package com.jtstack.webservice.demo2;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class WeatherInterfaceImpl implements WeatherInterface {

	@Override
	public String queryWeather(String cityName) {
		System.out.println("from client.." + cityName);
		String result = "晴朗";
		System.out.println("to client..." + result);
		return result;
	}

	public static void main(String[] args) {
		// 发送webservice服务
		Endpoint.publish("http://192.168.1.100:1234/weather", new WeatherInterfaceImpl());
	}

}

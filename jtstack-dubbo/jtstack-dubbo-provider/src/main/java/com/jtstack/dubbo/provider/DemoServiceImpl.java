package com.jtstack.dubbo.provider;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.jtstack.dubbo.api.DemoService;

public class DemoServiceImpl implements DemoService {

	public String sayHello(String name) {
		System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] Hello " + name);
		return "Hello " + name;
	}

}
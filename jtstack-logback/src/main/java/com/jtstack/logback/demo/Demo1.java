package com.jtstack.logback.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demo1 {

	public static void main(String[] args) {
		// 两种获取日志对象格式
		//1.通过全路径类名加载logger
		Logger logger1=LoggerFactory.getLogger("com.jtstack.logback.demo.Demo1");
		logger1.info("hello world!");
		//2.通过.class加载logger
		Logger logger2=LoggerFactory.getLogger(Demo1.class);
		logger2.info("hello world!");
	}
}

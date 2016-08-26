package com.jtstack.concurrent.executorservice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// 一个有7个作业线程的线程池，老大的老大找到一个管7个人的小团队的老大
		ExecutorService laodaA = Executors.newFixedThreadPool(7);
		// 提交作业给老大，作业内容封装在Callable中，约定好了输出的类型是String。
		String outputs = laodaA.submit(new Callable<String>() {
			public String call() throws Exception {
				return "I am a task, which submited by the so called laoda, and run by those anonymous workers";
			}
			// 提交后就等着结果吧，到底是手下7个作业中谁领到任务了，老大是不关心的。
		}).get();

		System.out.println(outputs);
	}

}

package com.jtstack.concurrent;

public class TestThread implements Runnable{
	
	private int id;
	
	public TestThread(int id) {
		this.id = id;
	}

	public void run() {
		try {
			System.out.println("thread id " + id + " start run");
			Thread.sleep(1000);
			System.out.println("thread id " + id + " end run");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

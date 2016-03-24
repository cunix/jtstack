package com.jtstack.rocketmq.demo;

import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;

public class Producer {

	public static void main(String[] args) {
		DefaultMQProducer producer = new DefaultMQProducer("Producer");
		producer.setNamesrvAddr("192.168.100.101:9876");
		try {
			producer.start();
			Message msg = new Message("PushTopic", "push", "1", "This Message Form Producer By Wincent!.".getBytes());
			SendResult result = producer.send(msg);
			System.out.println("id:" + result.getMsgId() + " result:" + result.getSendStatus());
			msg = new Message("PushTopic", "push", "1", "This Message Form Producer By Wincent!..".getBytes());
			result = producer.send(msg);
			System.out.println("id:" + result.getMsgId() + " result:" + result.getSendStatus());
			msg = new Message("PushTopic", "push", "1", "This Message Form Producer By Wincent!...".getBytes());
			result = producer.send(msg);
			System.out.println("id:" + result.getMsgId() + " result:" + result.getSendStatus());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			producer.shutdown();
		}
	}

}

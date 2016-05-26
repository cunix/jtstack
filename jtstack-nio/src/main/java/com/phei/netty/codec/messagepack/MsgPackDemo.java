package com.phei.netty.codec.messagepack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.msgpack.MessagePack;
import org.msgpack.template.Templates;

/**
 * @author Wincent<chengwang1992@gmail.com>
 * @date   2016年5月26日 上午11:02:31
 */
public class MsgPackDemo {

	
	public static void main(String[] args) throws IOException {
		
		List<String> src=new ArrayList<String>();
		src.add("msgpack");
		src.add("kumofs");
		src.add("viver");
		
		MessagePack msgpack=new MessagePack();
		byte[] raw = msgpack.write(src);
		System.out.println(new String(raw));
		
		List<String> dst=msgpack.read(raw, Templates.tList(Templates.TString));
		for (String str : dst) {
			System.out.println(str);
		}
		
		
	}
	
}

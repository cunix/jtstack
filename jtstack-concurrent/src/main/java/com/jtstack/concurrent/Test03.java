package com.jtstack.concurrent;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.joda.time.DateTime;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class Test03 {
	
	public static String data = "";

	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 50; i++) {
			sb.append("################################################################################################");
		}
		data = sb.toString();
		
		List<File> files = new ArrayList<File>();
		String floder = String.valueOf(System.currentTimeMillis());
		for (int i = 0; i < 1000; i++) {
//			createFile(floder + File.separator + String.valueOf(i));
			files.add(createFile(String.valueOf(i)));
		}
		System.out.println("run over" + files.size());
		try {
			Session session = SftpUtil.getSession("192.168.14.68", 0, "root", "root");
			ChannelSftp sftp = SftpUtil.getChannelSftp(session);
//			System.out.println(sftp);
			sftp.connect();
			DateTime dt = new DateTime();
			String dir = "/root/sftp/" + dt.getHourOfDay() + dt.getMinuteOfHour() + dt.getSecondOfMinute();
			sftp.mkdir(dir);
			long start = System.currentTimeMillis();
			// ############################################################################################
			ExecutorService threadPool = Executors.newFixedThreadPool(8);
			List<Future> futures = new CopyOnWriteArrayList<Future>();
			int fileSize = files.size();
			boolean isRun = true;
			int ci = 1;
			int endIndex = 0;
			int subListSize = 50;
			while (isRun) {
				List<File> subList;
				if (fileSize <= ci * subListSize) {//1*50
					endIndex = fileSize;
					isRun = false;
				} else {
					endIndex = ci * subListSize;
				}
				subList = files.subList((ci - 1) * subListSize, endIndex);
				UploadThread workThread = new UploadThread(session, dir,subList,ci, data);
				futures.add(threadPool.submit(workThread));
				ci++;
			}
			for (Future f : futures) {
				f.get();
			}
			long end = System.currentTimeMillis();
			System.out.println("thread use time   " + (end - start));
		} catch (JSchException e) {
			System.out.println("111111111111111111111");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("222222222222222222222");
			e.printStackTrace();
		}
		System.out.println("222222dfdfdfd2222222");
	}

	public static File createFile(String fileName) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 50; i++) {
			sb.append("################################################################################################");
		}
		try {
			File file = new File("E:\\sftpfile" + File.separator + fileName + ".txt");
			FileOutputStream fos = new FileOutputStream(file);
//			fos.write("".getBytes());
			fos.write(sb.toString().getBytes());
			fos.flush();
			fos.close();
			System.out.println(sb.length());
			return file;
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return null;
	}
	
	public static String createFile() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 50; i++) {
			sb.append(
					"################################################################################################");
		}
		return sb.toString();
	}

}

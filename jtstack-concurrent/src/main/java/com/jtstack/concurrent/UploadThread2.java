package com.jtstack.concurrent;

import java.io.File;
import java.util.List;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class UploadThread2 implements Runnable {

	private String dir;
	private File file;
	private ChannelSftp sftp;

	public UploadThread2(ChannelSftp sftp, String dir, File file) {
		this.dir = dir;
		this.file = file;
		this.sftp = sftp;
	}

	public void run() {
		try {
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + sftp.isConnected());
			long startConnect = System.currentTimeMillis();
			long endConnect = System.currentTimeMillis();
			SftpUtil.upload(sftp, file);
			long startClose = System.currentTimeMillis();
			//SftpUtil.closeChannelSftp(_sftp);
			long endClose = System.currentTimeMillis();
//			System.out.println("connect use time: " + (endConnect - startConnect));
//			System.out.println("close use time: " + (endClose - startClose));
//			System.out.println("run thread use time: " + (endClose - startConnect));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

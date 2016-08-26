package com.jtstack.concurrent;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;


import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.Session;

public class UploadThread implements Runnable {

	private Session session;
	private String dir;
	private List<File> files;
	private int index;
	private String data;

	public UploadThread(Session session, String dir, List<File> files, int index, String data) {
		this.session = session;
		this.dir = dir;
		this.files = files;
		this.index = index;
		this.data = data;
	}

	public void run() {
		try {
			System.out.println("##############thread run no  " + index);
			long startConnect = System.currentTimeMillis();
			ChannelSftp _sftp = (ChannelSftp) session.openChannel("sftp");
			_sftp.connect();
			_sftp.cd(dir);
			long endConnect = System.currentTimeMillis();
			for (File file : files) {
				//				SftpUtil.upload(_sftp, dir, new FileInputStream(file),file.getName());
				SftpUtil.upload(_sftp, dir, new ByteArrayInputStream(data.getBytes("UTF-8")),file.getName());
			}
			long startClose = System.currentTimeMillis();
			_sftp.quit();
			SftpUtil.closeChannelSftp(_sftp);
			long endClose = System.currentTimeMillis();
			System.out.println("run thread use time: " + index + "-----" + (endClose - startConnect));
			System.out.println("upload file use time: " + index + "-----" + (startClose - endConnect));
		} catch (Exception e) {
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@" + index);
			e.printStackTrace();
		}
	}

}

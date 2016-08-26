package com.jtstack.concurrent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;


public class SftpUtil {

	private static final Logger logger = Logger.getLogger(SftpUtil.class);

	/**
	 * 获取sftp session
	 * 
	 * @param host
	 * @param port
	 * @param username
	 * @param password
	 * @return
	 * @throws JSchException
	 */
	public static Session getSession(String host, Integer port, String username, String password) throws JSchException {
		Session session = null;
		JSch jSch = new JSch();
		if (0 <= port) {
			// 连接服务器，使用默认端口
			session = jSch.getSession(username, host);
		} else {
			session = jSch.getSession(username, host, port);
		}

		// 如果连接不上服务器，抛出异常
		if (null == session) {
			logger.warn("session is null");
			throw new JSchException("connect sftp server failed!Please check username,password,port is corrected");
		}

		// 设置登陆主机的密码
		session.setPassword(password);// 设置密码
		// 设置第一次登陆的时候提示，可选值：(ask | yes | no)
		session.setConfig("StrictHostKeyChecking", "no");
		// 设置登陆超时时间
		session.connect(30000);
		return session;
	}

	/**
	 * 关闭session
	 */
	public static void closeSession(Session session) {
		if (null != session && session.isConnected()) {
			session.disconnect();
		}
	}

	/**
	 * 获取channel
	 * 
	 * @param session
	 * @return
	 */
	public static ChannelSftp getChannelSftp(Session session) {
		ChannelSftp sftp = null;
		try {
			sftp = (ChannelSftp) session.openChannel("sftp");
		} catch (JSchException e) {
			logger.error("get channel fail ", e);
		}
		return sftp;
	}

	/**
	 * 关闭ChannelSftp
	 * 
	 * @param channel
	 */
	public static void closeChannelSftp(ChannelSftp sftp) {
		if (null != sftp) {
			if (sftp.isConnected()) {
				sftp.disconnect();
			}
		}
	}

	/**
	 * 关闭connect
	 * 
	 * @param sftp
	 */
	public static void disconnect(ChannelSftp sftp) {
		try {
			if (null != sftp) {
				if (sftp.isConnected()) {
					sftp.disconnect();
				}
			}
			if (null != sftp.getSession()) {
				sftp.getSession().disconnect();
			}
		} catch (JSchException e) {
			logger.error("close sftp connect fail ", e);
		}
	}
	
	/**
	 * 上传文件
	 * 
	 * @param sftp
	 * @param dir
	 * @param file
	 */
	public static void upload(ChannelSftp sftp, String dir, String uploadFile) {
		try {
			File file = new File(uploadFile);
			sftp.cd(dir);
			sftp.put(new FileInputStream(file), file.getName());
		} catch (SftpException e) {
			logger.error("sftp upload file fail ", e);
		} catch (FileNotFoundException e) {
			logger.error("sftp upload file not found ", e);
		}
	}
	
	/**
	 * 上传文件
	 * 
	 * @param sftp
	 * @param dir
	 * @param file
	 */
	public static void upload(ChannelSftp sftp, String dir, File file) {
		try {
			//sftp.cd(dir);
			sftp.put(new FileInputStream(file), file.getName());
		} catch (SftpException e) {
			logger.error("sftp upload file fail ", e);
		} catch (FileNotFoundException e) {
			logger.error("sftp upload file not found ", e);
		}
	}
	
	public static void upload(ChannelSftp sftp, String dir, InputStream ins, String file) {
		try {
			sftp.put(ins, file);
		} catch (SftpException e) {
			logger.error("sftp upload file fail ", e);
		}
	}
	
	public static void upload(ChannelSftp sftp, File file) {
		try {
			FileInputStream fis = new FileInputStream(file);
//			System.out.println("###########################" + sftp.isConnected());
			if(!sftp.isConnected()) {
				sftp.connect();
			}
//			System.out.println("###########################" + sftp.isConnected());
//			System.out.println("-------------------------------------------------------------------------");
			sftp.put(fis, file.getName());
		} catch (SftpException e) {
			logger.error("sftp upload file fail ", e);
		} catch (FileNotFoundException e) {
			logger.error("sftp upload file not found ", e);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
		}
	}
	
	/**
	 * 删除文件
	 * 
	 * @param sftp
	 * @param dir
	 * @param file
	 */
	public static void delete(ChannelSftp sftp, String dir, String file) {
		try {
			sftp.cd(dir);
			sftp.rm(file);
		} catch (SftpException e) {
			logger.error("delete file fail ", e);
		}
	}
	
	public static void mkdir(ChannelSftp sftp, String dir) {
	}

}

package com.zijin.microon.ueditor.upload;

import com.zijin.microon.ueditor.ActionEnter;
import com.zijin.microon.ueditor.define.BaseState;
import com.zijin.microon.ueditor.define.State;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class StorageManager {
	private static Log log=LogFactory.getLog(StorageManager.class);
	
	public static final int BUFFER_SIZE = 8192;

	/**
	 * 将字节数组作为二进制文件保存到指定文件中
	 * @author adli  2015年7月19日 下午6:07:29
	 * @param data
	 * @param path
	 * @return
	 */
	public static State saveBinaryFile(byte[] data, String path) {
		File file = new File(path);

		State state = valid(file);

		if (!state.isSuccess()) {
			return state;
		}
		try {
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
			bos.write(data);
			bos.flush();
			bos.close();
		} catch (IOException ioe) {
			log.error(ioe);
			return new BaseState(false, 4);
		}

		state = new BaseState(true, file.getAbsolutePath());
		state.putInfo("size", data.length);
		state.putInfo("title", file.getName());
		return state;
	}

	public static State saveFileByInputStream(InputStream is, String path, long maxSize) {
		State state = null;

		File tmpFile = getTmpFile();

		byte[] dataBuf = new byte[2048];
		BufferedInputStream bis = new BufferedInputStream(is, 8192);
		try {
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(tmpFile), 8192);

			int count = 0;
			while ((count = bis.read(dataBuf)) != -1) {
				bos.write(dataBuf, 0, count);
			}
			bos.flush();
			bos.close();

			if (tmpFile.length() > maxSize) {
				tmpFile.delete();
				return new BaseState(false, 1);
			}

			state = saveTmpFile(tmpFile, path);

			if (!state.isSuccess()) {
				tmpFile.delete();
			}

			return state;
		} catch (IOException localIOException) {
			log.error(localIOException);
		}
		return new BaseState(false, 4);
	}

	public static State saveFileByInputStream(InputStream is, String path) {
		State state = null;

		File tmpFile = getTmpFile();

		byte[] dataBuf = new byte[2048];
		BufferedInputStream bis = new BufferedInputStream(is, 8192);
		try {
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(tmpFile), 8192);

			int count = 0;
			while ((count = bis.read(dataBuf)) != -1) {
				bos.write(dataBuf, 0, count);
			}
			bos.flush();
			bos.close();

			state = saveTmpFile(tmpFile, path);

			if (!state.isSuccess()) {
				tmpFile.delete();
			}

			return state;
		} catch (IOException localIOException) {
			log.error(localIOException);
		}
		return new BaseState(false, 4);
	}

	/**
	 * 在系统临时目录中创建文件（文件名随机）并返回
	 * @author adli  2015年7月19日 下午5:56:56
	 * @return
	 */
	private static File getTmpFile() {
		File tmpDir = FileUtils.getTempDirectory();
		String tmpFileName = (Double.toString(Math.random() * 10000.0D)).replace(".", "");
		return new File(tmpDir, tmpFileName);
	}

	/**
	 * 保存临时文件到指定目录
	 * @author adli  2015年7月19日 下午6:00:33
	 * @param tmpFile
	 * @param path
	 * @return
	 */
	private static State saveTmpFile(File tmpFile, String path) {
		State state = null;
		File targetFile = new File(path);

		if (targetFile.canWrite())
			return new BaseState(false, 2);
		try {
			FileUtils.moveFile(tmpFile, targetFile);
		} catch (IOException e) {
			return new BaseState(false, 4);
		}

		state = new BaseState(true);
		state.putInfo("size", targetFile.length());
		state.putInfo("title", targetFile.getName());

		return state;
	}

	/**
	 * 验证文件路径合法性
	 * @author adli  2015年7月19日 下午5:50:59
	 * @param file
	 * @return
	 */
	private static State valid(File file) {
		File parentPath = file.getParentFile();

		//上级目录不存在，则创建上级目录
		if ((!parentPath.exists()) && (!parentPath.mkdirs())) {
			return new BaseState(false, 3);
		}

		if (!parentPath.canWrite()) {
			return new BaseState(false, 2);
		}

		return new BaseState(true);
	}
}

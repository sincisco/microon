package com.zijin.microon.ueditor.hunter;

import com.zijin.microon.ueditor.ActionEnter;
import com.zijin.microon.ueditor.PathFormat;
import com.zijin.microon.ueditor.define.BaseState;
import com.zijin.microon.ueditor.define.MultiState;
import com.zijin.microon.ueditor.define.State;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FileManager {
	private static Log log = LogFactory.getLog(FileManager.class);
	private String dir = null;
	private String rootPath = null;
	private String[] allowFiles = null;
	private int count = 0;

	public FileManager(Map<String, Object> conf) {
		this.rootPath = ((String) conf.get("rootPath"));
		this.dir = (this.rootPath + (String) conf.get("dir"));
		this.allowFiles = getAllowFiles(conf.get("allowFiles"));
		this.count = ((Integer) conf.get("count")).intValue();
	}

	public State listFile(int index)
   {
	 log.info("读取图片文件列表");
	 log.info("文件目录："+this.dir);
     File dir = new File(this.dir);
     State state = null;
 
     if (!dir.exists()) {
       return new BaseState(false, 302);
     }
 
     if (!dir.isDirectory()) {
       return new BaseState(false, 301);
     }
 
     Collection list = FileUtils.listFiles(dir, this.allowFiles, true);
 
     if ((index < 0) || (index > list.size())) {
       state = new MultiState(true);
     } else {
       Object[] fileList = Arrays.copyOfRange(list.toArray(), index, index + this.count);
       for (Object object : fileList) {
    	   if(object!=null)
		log.info(object.toString());
	}
       state = getState(fileList);
     }
 
     state.putInfo("start", index);
     state.putInfo("total", list.size());
 
     return state;
   }

	private State getState(Object[] files) {
		MultiState state = new MultiState(true);
		BaseState fileState = null;

		File file = null;

		for (Object obj : files) {
			if (obj == null) {
				break;
			}
			file = (File) obj;
			fileState = new BaseState(true);
			log.info(getPath(file));
			log.info(PathFormat.format(getPath(file)));
			fileState.putInfo("url", getPath(file));
			state.addState(fileState);
		}

		return state;
	}

	
	/**
	 * 生成文件的相对路径
	 * @author adli  2015年7月19日 下午12:31:42
	 * @param file
	 * @return
	 */
	private String getPath(File file) {
		String path = file.getAbsolutePath();

		path=PathFormat.format(path);
		
		return path.replace(this.rootPath, "/microon/");
	}

	/**
	 * 返回允许的文件类型
	 * @author adli  2015年7月19日 下午4:49:28
	 * @param fileExt 允许的文件类型后缀
	 * @return
	 */
	private String[] getAllowFiles(Object fileExt) {
		String[] exts = null;
		String ext = null;

		if (fileExt == null) {
			return new String[0];
		}

		exts = (String[]) fileExt;

		int i = 0;
		for (int len = exts.length; i < len; i++) {
			ext = exts[i];
			exts[i] = ext.replace(".", "");
		}

		return exts;
	}
}

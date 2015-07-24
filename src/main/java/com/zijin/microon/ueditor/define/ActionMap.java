package com.zijin.microon.ueditor.define;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据请求动作转换为内部编码
 * @author adli  2015年7月19日 下午5:02:59
 *
 */
public final class ActionMap {
	public static final Map<String, Integer> mapping = new HashMap<String, Integer>() {
	};
	public static final int CONFIG = 0;
	public static final int UPLOAD_IMAGE = 1;
	public static final int UPLOAD_SCRAWL = 2;
	public static final int UPLOAD_VIDEO = 3;
	public static final int UPLOAD_FILE = 4;
	public static final int CATCH_IMAGE = 5;
	public static final int LIST_FILE = 6;
	public static final int LIST_IMAGE = 7;

	static {
		mapping.put("config", CONFIG);
		mapping.put("uploadimage", UPLOAD_IMAGE);
		mapping.put("uploadscrawl", UPLOAD_SCRAWL);
		mapping.put("uploadvideo", UPLOAD_VIDEO);
		mapping.put("uploadfile", UPLOAD_FILE);
		mapping.put("catchimage", CATCH_IMAGE);
		mapping.put("listfile", LIST_FILE);
		mapping.put("listimage", LIST_IMAGE);
	}

	public static int getType(String key) {
		return ((Integer) mapping.get(key)).intValue();
	}
}

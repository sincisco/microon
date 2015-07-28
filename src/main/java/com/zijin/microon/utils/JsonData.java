package com.zijin.microon.utils;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author adli
 */
public class JsonData {

	private List<?> rows = new ArrayList();

	private List<Object> footer = null;

	@JSONField(serialize = false)
	private Integer totalInternal = null;

	private Boolean success = true;

	private String message = null;

	public JsonData() {
	}

	public int getTotal() {
		return totalInternal == null ? rows.size() : totalInternal;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public List<Object> getFooter() {
		return footer;
	}

	public void setFooter(List<Object> footer) {
		this.footer = footer;
	}

	public Integer getTotalInternal() {
		return totalInternal;
	}

	public void setTotalInternal(Integer totalInternal) {
		this.totalInternal = totalInternal;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

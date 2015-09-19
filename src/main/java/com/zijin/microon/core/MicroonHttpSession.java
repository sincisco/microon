package com.zijin.microon.core;

import java.util.Enumeration;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

public class MicroonHttpSession implements HttpSession {

	private String uuid=null;
	private ServletContext servletContext=null;
	private long creationTime=0L;
	private long lastAccessedTime=0L;
	private int maxInactiveInterval=0;
	private ConcurrentHashMap<String, Object> map=null;
	public MicroonHttpSession() {
		this.creationTime=System.currentTimeMillis();
		this.uuid=UUID.randomUUID().toString();
		this.map= new ConcurrentHashMap<String, Object>();
	}

	public long getCreationTime() {
		return creationTime;
	}

	public String getId() {
		return uuid;
	}

	public long getLastAccessedTime() {
		return lastAccessedTime;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setMaxInactiveInterval(int interval) {
		 maxInactiveInterval=interval;
	}

	public int getMaxInactiveInterval() {
		return maxInactiveInterval;
	}

	public HttpSessionContext getSessionContext() {
		return null;
	}

	public Object getAttribute(String name) {
		return map.get(name);
	}

	public Object getValue(String name) {
		return map.get(name);
	}

	public Enumeration<String> getAttributeNames() {
		return null;
	}

	public String[] getValueNames() {
		return null;
	}

	public void setAttribute(String name, Object value) {
		map.put(name, value);
	}

	public void putValue(String name, Object value) {
		map.put(name, value);
	}

	public void removeAttribute(String name) {

	}

	public void removeValue(String name) {

	}

	public void invalidate() {

	}

	public boolean isNew() {
		return false;
	}

}

package com.zijin.microon.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;

public class MicroonHttpServletRequest implements HttpServletRequest {

	private static Log log = LogFactory.getLog(MicroonHttpServletRequest.class);
	private String characterEncoding="utf-8";
	private ServletContext servletContext=null;
	public MicroonHttpServletRequest() {
		// TODO Auto-generated constructor stub
	}
	
	public MicroonHttpServletRequest(ServletContext servletContext) {
		this.servletContext=servletContext;
	}

	public Object getAttribute(String name) {
		log.info("getAttribute:"+name);
		return null;
	}

	public Enumeration<String> getAttributeNames() {
		log.info("getInputStream");
		return null;
	}

	public String getCharacterEncoding() {
		log.info("getInputStream");
		return characterEncoding;
	}

	public void setCharacterEncoding(String env) throws UnsupportedEncodingException {
		this.characterEncoding=env;

	}

	public int getContentLength() {
		log.info("getInputStream");
		return 0;
	}

	public String getContentType() {
		log.info("getInputStream");
		return null;
	}

	public ServletInputStream getInputStream() throws IOException {
		log.info("getInputStream");
		return null;
	}

	public String getParameter(String name) {
		log.info("getInputStream");
		return null;
	}

	public Enumeration<String> getParameterNames() {
		log.info("getInputStream");
		return null;
	}

	public String[] getParameterValues(String name) {
		log.info("getInputStream");
		return null;
	}

	public Map<String, String[]> getParameterMap() {
		log.info("getInputStream");
		return null;
	}

	public String getProtocol() {
		log.info("getInputStream");
		return null;
	}

	public String getScheme() {
		log.info("getInputStream");
		return null;
	}

	public String getServerName() {
		log.info("getInputStream");
		return null;
	}

	public int getServerPort() {
		return 0;
	}

	public BufferedReader getReader() throws IOException {
		log.info("getInputStream");
		return null;
	}

/*	getRemoteAddr getRemoteHost
 * 前一个是获得客户端的ip地址    
	后一个是获得客户端的主机名    
	在JSP里，获取客户端的IP地址的方法是：request.getRemoteAddr()，
	这种方法在大部分情况下都是有效的。
	但是在通过了Apache,Squid等反向代理软件就不能获取到客户端的真实IP地址了。*/

	public String getRemoteAddr() {
		return "127.0.0.1";
	}

	public String getRemoteHost() {
		return "127.0.0.1";
	}

	public void setAttribute(String name, Object o) {
		log.info("getInputStream");

	}

	public void removeAttribute(String name) {
		log.info("getInputStream");

	}

	public Locale getLocale() {
		log.info("getInputStream");
		return null;
	}

	public Enumeration<Locale> getLocales() {
		log.info("getInputStream");
		return null;
	}

	public boolean isSecure() {
		log.info("getInputStream");
		return false;
	}

	public RequestDispatcher getRequestDispatcher(String path) {
		log.info("getRequestDispatcher");
		return servletContext.getRequestDispatcher(path);
	}

	public String getRealPath(String path) {
		log.info("getRealPath");
		return servletContext.getRealPath(path);
	}

	public int getRemotePort() {
		log.info("getRemotePort");
		return 0;
	}

	public String getLocalName() {
		log.info("getInputStream");
		return null;
	}

	public String getLocalAddr() {
		log.info("getInputStream");
		return null;
	}

	public int getLocalPort() {
		log.info("getInputStream");
		return 0;
	}

	public ServletContext getServletContext() {
		log.info("getServletContext");
		return servletContext;
	}

	public AsyncContext startAsync() throws IllegalStateException {
		log.info("getInputStream");
		return null;
	}

	public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse)
			throws IllegalStateException {
		log.info("getInputStream");
		return null;
	}

	public boolean isAsyncStarted() {
		log.info("getInputStream");
		return false;
	}

	public boolean isAsyncSupported() {
		log.info("getInputStream");
		return false;
	}

	public AsyncContext getAsyncContext() {
		log.info("getInputStream");
		return null;
	}

	public DispatcherType getDispatcherType() {
		log.info("getInputStream");
		return null;
	}

	public String getAuthType() {
		log.info("getInputStream");
		return null;
	}

	public Cookie[] getCookies() {
		log.info("getInputStream");
		return null;
	}

	public long getDateHeader(String name) {
		log.info("getInputStream");
		return 0;
	}

	public String getHeader(String name) {
		log.info("getInputStream");
		return null;
	}

	public Enumeration<String> getHeaders(String name) {
		log.info("getInputStream");
		return null;
	}

	public Enumeration<String> getHeaderNames() {
		log.info("getInputStream");
		return null;
	}

	public int getIntHeader(String name) {
		log.info("getInputStream");
		return 0;
	}

	public String getMethod() {
		log.info("getMethod");
		return "GET";
	}

	public String getPathInfo() {
		log.info("getPathInfo");
		return "/";
	}

	public String getPathTranslated() {
		log.info("getInputStream");
		return null;
	}

	public String getContextPath() {
		log.info("getContextPath:"+servletContext.getContextPath());
		return servletContext.getContextPath();
	}

	public String getQueryString() {
		log.info("getInputStream");
		return null;
	}

	public String getRemoteUser() {
		log.info("getInputStream");
		return null;
	}

	public boolean isUserInRole(String role) {
		log.info("getInputStream");
		return false;
	}

	public Principal getUserPrincipal() {
		log.info("getInputStream");
		return null;
	}

	public String getRequestedSessionId() {
		log.info("getInputStream");
		return null;
	}

	public String getRequestURI() {
		log.info("getInputStream");
		return null;
	}

	public StringBuffer getRequestURL() {
		log.info("getInputStream");
		return null;
	}

	public String getServletPath() {
		log.info("getInputStream");
		return null;
	}

	public HttpSession getSession(boolean create) {
		return null;
	}

	public HttpSession getSession() {
		log.info("getInputStream");
		return null;
	}

	public boolean isRequestedSessionIdValid() {
		log.info("getInputStream");
		return false;
	}

	public boolean isRequestedSessionIdFromCookie() {
		log.info("getInputStream");
		return false;
	}

	public boolean isRequestedSessionIdFromURL() {
		log.info("getInputStream");
		return false;
	}

	public boolean isRequestedSessionIdFromUrl() {
		log.info("getInputStream");
		return false;
	}

	public boolean authenticate(HttpServletResponse response) throws IOException, ServletException {
		log.info("getInputStream");
		return false;
	}

	public void login(String username, String password) throws ServletException {
		log.info("getInputStream");

	}

	public void logout() throws ServletException {
		log.info("getInputStream");

	}

	public Collection<Part> getParts() throws IOException, ServletException {
		log.info("getInputStream");
		return null;
	}

	public Part getPart(String name) throws IOException, ServletException {
		log.info("getInputStream");
		return null;
	}

}

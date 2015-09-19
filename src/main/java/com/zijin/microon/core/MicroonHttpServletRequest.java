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
	private HttpSession httpSession=null;
	public MicroonHttpServletRequest() {
		// TODO Auto-generated constructor stub
	}
	
	public MicroonHttpServletRequest(ServletContext servletContext) {
		this.servletContext=servletContext;
		this.httpSession=new MicroonHttpSession();
	}
	
	public MicroonHttpServletRequest(ServletContext servletContext,HttpSession httpSession) {
		this.servletContext=servletContext;
		this.httpSession=httpSession;
	}

	public Object getAttribute(String name) {
		log.info("getAttribute:"+name);
		return null;
	}

	public Enumeration<String> getAttributeNames() {
		log.info("getInputStream");
		return null;
	}

	
/*	目前，许多浏览器在Content-Type头中不会指定字符编码方式，
	那么容器就会使用"ISO-8859-1"方式解析POST数据，
	而此时，为了向开发人员提示字符编码方式未指定，容器将会在getCharacterEncoding返回null.
	 如果客户机没有设置字符编码信息，但是request数据又以和缺省编码方式不同的方式编码，
	 就会发生数据破坏。setCharacterEncoding(String enc)方法可以防止这种状况发生，
	 但是必须在解析数据或从request中读取数据之前调用。否则调用该方法不会有任何效果。*/
	public String getCharacterEncoding() {
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
		return httpSession;
	}

	public HttpSession getSession() {
		return httpSession;
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
		return null;
	}

/*	在Servlet3.0中上传文件变得非常简单。
	我们只需通过request的getPart(String partName)
	获取到上传的对应文件对应的Part或者通过getParts()方法获取到所有上传文件对应的Part。
	之后我们就可以通过part的write(String fileName)方法把对应文件写入到磁盘。
	或者通过part的getInputStream()方法获取文件对应的输入流，然后再对该输入流进行操作。
	要使用request的getPart()或getParts()方法对上传的文件进行操作的话，有两个要注意的地方。*/
	public Part getPart(String name) throws IOException, ServletException {
		return null;
	}

}

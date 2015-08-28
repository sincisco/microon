package com.zijin.microon.core;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MicroonHttpServletResponse implements HttpServletResponse{
	private static Log log = LogFactory.getLog(MicroonHttpServletResponse.class);
	public MicroonHttpServletResponse() {
		
	}

	public String getCharacterEncoding() {
		log.info("getCharacterEncoding");
		return null;
	}

	public String getContentType() {
		log.info("getCharacterEncoding");
		return null;
	}

	public ServletOutputStream getOutputStream() throws IOException {
		log.info("getCharacterEncoding");
		return null;
	}

	public PrintWriter getWriter() throws IOException {
		log.info("getCharacterEncoding");
		return null;
	}

	public void setCharacterEncoding(String charset) {
		log.info("getCharacterEncoding");
		
	}

	public void setContentLength(int len) {
		log.info("getCharacterEncoding");
		
	}

	public void setContentType(String type) {
		log.info("getCharacterEncoding");
		
	}

	public void setBufferSize(int size) {
		log.info("getCharacterEncoding");
		
	}

	public int getBufferSize() {
		log.info("getCharacterEncoding");
		return 0;
	}

	public void flushBuffer() throws IOException {
		log.info("getCharacterEncoding");
		
	}

	public void resetBuffer() {
		log.info("getCharacterEncoding");
		
	}

	public boolean isCommitted() {
		log.info("getCharacterEncoding");
		return false;
	}

	public void reset() {
		log.info("getCharacterEncoding");
		
	}

	public void setLocale(Locale loc) {
		log.info("getCharacterEncoding");
		
	}

	public Locale getLocale() {
		log.info("getCharacterEncoding");
		return null;
	}

	public void addCookie(Cookie cookie) {
		log.info("getCharacterEncoding");
		
	}

	public boolean containsHeader(String name) {
		log.info("getCharacterEncoding");
		return false;
	}

	public String encodeURL(String url) {
		log.info("getCharacterEncoding");
		return null;
	}

	public String encodeRedirectURL(String url) {
		log.info("getCharacterEncoding");
		return null;
	}

	public String encodeUrl(String url) {
		log.info("getCharacterEncoding");
		return null;
	}

	public String encodeRedirectUrl(String url) {
		log.info("getCharacterEncoding");
		return null;
	}

	public void sendError(int sc, String msg) throws IOException {
		log.info("getCharacterEncoding");
		
	}

	public void sendError(int sc) throws IOException {
		log.info("getCharacterEncoding");
		
	}

	public void sendRedirect(String location) throws IOException {
		log.info("getCharacterEncoding");
		
	}

	public void setDateHeader(String name, long date) {
		log.info("getCharacterEncoding");
		
	}

	public void addDateHeader(String name, long date) {
		log.info("getCharacterEncoding");
		
	}

	public void setHeader(String name, String value) {
		log.info("getCharacterEncoding");
		
	}

	public void addHeader(String name, String value) {
		log.info("getCharacterEncoding");
		
	}

	public void setIntHeader(String name, int value) {
		log.info("getCharacterEncoding");
		
	}

	public void addIntHeader(String name, int value) {
		log.info("getCharacterEncoding");
		
	}

	public void setStatus(int sc) {
		log.info("getCharacterEncoding");
		
	}

	public void setStatus(int sc, String sm) {
		log.info("getCharacterEncoding");
		
	}

	public int getStatus() {
		log.info("getCharacterEncoding");
		return 0;
	}

	public String getHeader(String name) {
		log.info("getCharacterEncoding");
		return null;
	}

	public Collection<String> getHeaders(String name) {
		log.info("getCharacterEncoding");
		return null;
	}

	public Collection<String> getHeaderNames() {
		log.info("getCharacterEncoding");
		return null;
	}

}

package com.zijin.microon.core;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;

@Service
public class HtmlBuilder implements ServletContextAware ,InitializingBean{
	private static Log log = LogFactory.getLog(HtmlBuilder.class);
	private ServletContext servletContext = null;

	public ServletContext getServletContext() {
		return servletContext;
	}

	public HtmlBuilder() {

	}

	/**
	 * 参数requestPageUrl想要生成html的jsp文件路径（如：/frontStage/articleMenuContent.jsp）,
	 * 这是实际存在的jsp文件 （同时我看了一些API想找到只需要传过来一个action也可以的方法，但是找不到...请高手帮帮忙..指点一下）
	 * 参数createPagePath为存放生成html的路径（如：/frontStage/articleMenuContent.html）
	 **/
	public void createStaticPage(String requestPageUrl, String htmlFilePath) throws Exception {
		/**
		 * 创建ServletContext对象，用于获取RequestDispatcher对象
		 */
		ServletContext sc = servletContext;

		/**
		 * 根据传过来的相对文件路径，生成一个reqeustDispatcher的包装类
		 */
		RequestDispatcher requestDispatcher = sc.getRequestDispatcher(requestPageUrl);

		HttpServletRequest request = new MicroonHttpServletRequest(servletContext);
		HttpServletResponse response = new MicroonHttpServletResponse();

		final ByteArrayOutputStream baos = new ByteArrayOutputStream();

		//ServletOutputStream是抽象类，必须实现write的方法
		final ServletOutputStream outputStream = new ServletOutputStream() {
			@Override
			public void write(int b) throws IOException {
				/**
				 * 将指定的字节写入此字节输出流
				 */
				baos.write(b);
			}
		};
		/**
		 * 通过现有的 OutputStream 创建新的 PrintWriter OutputStreamWriter
		 * 是字符流通向字节流的桥梁：可使用指定的 charset 将要写入流中的字符编码成字节
		 */
		final PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(baos, "utf-8"), true);

		/**
		 * 生成HttpServletResponse的适配器，用来包装response
		 */
		HttpServletResponse resp = new HttpServletResponseWrapper(response) {
			/**
			 * 调用getOutputStream的方法(此方法是ServletResponse中已有的)
			 * 返回ServletOutputStream的对象 用来在response中返回一个二进制输出对象
			 * 此方法目的是把源文件写入byteArrayOutputStream
			 */
			public ServletOutputStream getOutputStream() {
				return outputStream;
			}

			/**
			 * 再调用getWriter的方法(此方法是ServletResponse中已有)返回PrintWriter的对象
			 * 此方法用来发送字符文本到客户端
			 */
			public PrintWriter getWriter() {
				return printWriter;
			}
		};
		/**
		 * 在不跳转下访问目标jsp。 就是利用RequestDispatcher.include(ServletRequest request,
		 * ServletResponse response)。 该方法把RequestDispatcher指向的目标页面写到response中。
		 */
		requestDispatcher.include(request, resp);
		printWriter.flush();
		FileOutputStream fos = new FileOutputStream(htmlFilePath);
		/**
		 * 使用ByteArrayOutputStream的writeTo方法来向文本输出流写入数据，这也是为什么要使用ByteArray的一个原因
		 */
		baos.writeTo(fos);
		fos.close();
	}

	public void setServletContext(ServletContext arg0) {
		this.servletContext = arg0;

	}

	public void afterPropertiesSet() throws Exception {
		final HtmlBuilder htmlBuilder=this;
		Thread thread=new Thread(new Runnable() {
			
			public void run() {
				try {
					
					while (true) {
						if(htmlBuilder.getServletContext()!=null){
							htmlBuilder.createStaticPage("/html/articleCategory.html", "c:\\temp\\temp.html");
						}
						Thread.currentThread().sleep(10000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
					log.error(e);
				}catch (Exception e) {
					log.error(e);
					e.printStackTrace();
				}
				
			}
		});
		thread.start();
		
	}

}

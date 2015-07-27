/**
 * 
 */
package com.zijin.microon.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zijin.microon.exception.AuthorizationException;

/**
 * 身份验证
 * 
 * @author 李大虾 2015年7月25日 下午9:41:02 SecurityInterceptor
 */
public class SecurityInterceptor implements HandlerInterceptor {

	private static Log log = LogFactory.getLog(SecurityInterceptor.class);

	private List<String> excludedUrls;
	
	public  SecurityInterceptor() {
		log.debug("start*********************SecurityInterceptor");
	}

	public void setExcludedUrls(List<String> excludedUrls) {
		this.excludedUrls = excludedUrls;
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// excluded URLs:
		// see
		// http://stackoverflow.com/questions/9908124/spring-mvc-3-interceptor-on-all-excluding-some-defined-paths
		String requestUri = request.getRequestURI();
		log.debug(requestUri);
		
		for (String url : excludedUrls) {
			if (requestUri.endsWith(url)) {
				return true;
			}
		}

		
		// intercept
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			return true;
			// see
			// http://stackoverflow.com/questions/12713873/spring-3-1-how-do-you-send-all-exception-to-one-page
			//throw new AuthorizationException();
		} else {
			return true;
		}
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

}

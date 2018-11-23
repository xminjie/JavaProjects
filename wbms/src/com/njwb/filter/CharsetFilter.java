package com.njwb.filter;

 import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;
 
public class CharsetFilter implements Filter {
	Logger log =  Logger.getLogger(CharsetFilter.class);
	String encoding = null;

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
//		response.setCharacterEncoding(encoding);
//		response.setContentType("text/html;charset=utf-8");
		filterChain.doFilter(request, response);
		log.info("字符集过滤被放行" + encoding);
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		encoding = filterConfig.getServletContext().getInitParameter("encoding");
		if(encoding == null){
			encoding = "utf-8";
		}
		log.info("初始化字符集"  + encoding);
 		
	}
 

	 
}

package com.njwb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class AuthorFilter implements Filter {
	Logger log = Logger.getLogger(AuthorFilter.class);
	String notAuthor = null;
	String[] notAuthors = null;

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterConfig) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String path = req.getServletPath();
		if (isInAuthor(path)) {

			if (req.getSession().getAttribute("loginUser") == null) {
				log.info("权限过滤 " + path + " 被打回登陆");
				res.sendRedirect(req.getContextPath() + "/login.jsp");
			}
		}
		filterConfig.doFilter(request, response);
		log.info("权限过滤 " + path + "  被放行");

	}

	public void init(FilterConfig filterConfig) throws ServletException {
		notAuthor = filterConfig.getInitParameter("notAuthor");
		notAuthors = notAuthor.split(",");
		log.info("不需要校验权限的地址" + notAuthor);

	}

	// 是否需要校验权限
	Boolean isInAuthor(String path) {
		for (String not : notAuthors) {
			if (path.endsWith(not)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new AuthorFilter().notAuthors);
	}

}

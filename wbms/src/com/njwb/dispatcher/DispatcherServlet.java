package com.njwb.dispatcher;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.njwb.entity.ActionConfig;
import com.njwb.entity.ResultConfig;
import com.njwb.factory.ApplicationContext;

public class DispatcherServlet extends HttpServlet {

	private Logger log = Logger.getLogger(DispatcherServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// this.dispatch(req, resp);
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.dispatch(req, resp);
	}

	private void dispatch(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 1.拿到浏览器的请求地址
		// http://127.0.0.1:8080/teacher_jsp/login.action
		// req.getContextPath(); ///teacher_jsp
		// req.getRequestURI(); // /teacher_jsp/login.action
		String path = req.getServletPath(); // /login.action
		log.debug("请求地址:" + path);
		// 2.根据请求地址,到mvc.xml中拿匹配的action
		ActionConfig action = ActionUtil.getAction(path);
		if (action == null) {
			log.info("根据请求地址,找不到对应的action, path:" + path);
			return;
		}
		try {
			log.debug("请求地址对应的action:" + action);
			// 3.拿到对应的class地址,拿到方法名
			//Class clazz = Class.forName(action.getClassName());
			//Object obj = clazz.newInstance();
			//具体的类的对象实例,从工厂中拿,也就是说所有的Controller的实例都交给对象工厂去管理
			Object obj = ApplicationContext.getObject(action.getClassName());
			Class clazz = obj.getClass();
			// 4.拿到方法对象
			// 方法的形参:定义只有两个, (HttpServletRequest, HttpServletResponse)
			Method method = clazz.getDeclaredMethod(action.getMethod(),
					HttpServletRequest.class, HttpServletResponse.class);
			// 5.执行这个方法--->请求的分发
			// 6.拿到方法执行的返回值
			Object result = method.invoke(obj, req, resp);
			String methodResult = (String) result;

			log.debug("方法返回值:" + methodResult);

			// 7.再到action中,根据方法的返回值找到对应的ResultConfig
			Map<String, ResultConfig> resultMap = action.getResultMap();
			if (resultMap == null || resultMap.get(methodResult) == null) {
				log.info("action没有result配置,或者根据方法的返回值:" + methodResult
						+ ",找不到对应的result." + action);
				return;
			}
			// 8.页面的跳转(跳转方式:resultConfig.type, 跳转的地址:resultConfig.pagePath)
			ResultConfig resultConfig = resultMap.get(methodResult);
			if ("redirect".equals(resultConfig.getType())) {
				resp.sendRedirect(req.getContextPath()
						+ resultConfig.getPagePath());

			} else if ("forward".equals(resultConfig.getType())) {
				req.getRequestDispatcher(resultConfig.getPagePath()).forward(
						req, resp);
			} else {
				log.info("没有匹配的跳转方式." + action + ",result对象:" + resultConfig);
			}

		} catch (IllegalAccessException e) {
			log.info("生成类实例失败," + action, e);
		} catch (NoSuchMethodException e) {
			log.info("获取方法对象失败," + action, e);
		} catch (SecurityException e) {
			log.info("获取方法对象失败," + action, e);
		} catch (IllegalArgumentException e) {
			log.info("执行方法失败," + action, e);
		} catch (InvocationTargetException e) {
			log.info("执行方法失败," + action, e);
		}
	}
}

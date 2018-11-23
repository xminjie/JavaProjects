package com.njwb.entity;

import java.util.HashMap;

public class ActionConfig {
	
	/*
	 * name  从url发过来的地址名字， 由分发器分发处理
	 * className 处理请求的controller类（相当于原来的servlet）
	 * method    controller类需要调用的方法
	 *resultMap  执行结果后的返回之
	*/
	private String name ;
	private String className;
	private String method;
	private HashMap<String, ResultConfig> resultMap;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public HashMap<String, ResultConfig> getResultMap() {
		return resultMap;
	}
	public void setResultMap(HashMap<String, ResultConfig> resultMap) {
		this.resultMap = resultMap;
	}
	@Override
	public String toString() {
		return "ActionConfig [className=" + className + ", method=" + method
				+ ", name=" + name + ", resultMap=" + resultMap + "]";
	}
	
	
	
	
	
	
	
}

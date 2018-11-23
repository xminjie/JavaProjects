package com.njwb.entity;

public class ResultConfig {
	
	/*
	 * name 返回结果的名字
	 * type 返回结果类型   sendRediect or requestDispatch
	 * name 返回结果的名字 转发或者重定向的地址
	 * 
	 */
	
	private String name;
	private String type;
	private String pagePath;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPagePath() {
		return pagePath;
	}
	public void setPagePath(String pagePath) {
		this.pagePath = pagePath;
	}
	@Override
	public String toString() {
		return "ResultConfig [name=" + name + ", pagePath=" + pagePath
				+ ", type=" + type + "]";
	}
	
	
	
	
}

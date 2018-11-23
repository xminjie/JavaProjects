package com.njwb.entity;

import java.util.Date;
import java.util.HashMap;

import org.apache.commons.collections.map.HashedMap;

 
public class Role {
 
	
	
	private Integer roleId;
	private String roleName;
	private Date roleCreateTime;
	private HashMap<Long, Integer> accessMenu;
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Date getRoleCreateTime() {
		return roleCreateTime;
	}
	public void setRoleCreateTime(Date roleCreateTime) {
		this.roleCreateTime = roleCreateTime;
	}
	public HashMap<Long, Integer> getAccessMenu() {
		return accessMenu;
	}
	public void setAccessMenu(HashMap<Long, Integer> accessMenu) {
		this.accessMenu = accessMenu;
	}
	@Override
	public String toString() {
		return "Role [accessMenu=" + accessMenu + ", roleCreateTime="
				+ roleCreateTime + ", roleId=" + roleId + ", roleName="
				+ roleName + "]";
	}
	 
}

	
	
	
	
	
	
//
//-- 角色表
//drop table  if exists t_role;
//create table t_role(
//	role_id int auto_increment primary key,
//	role_name varchar(10) unique,
//	role_create_time date
//)engine=Innodb,  charset = utf8;
//
//insert into t_role values(1,'管理员',now());
//insert into t_role values(2,'普通用户',now());
//insert into t_role values(3,'财务',now());
//select * from t_role;
////
package com.njwb.entity;

import java.util.Date;

public class User {
	private Integer id;
	private String account;
	private String passwd;
	private Integer roleId;
	private Date createTime;
	private Integer status;
	private String name;
	private String roleName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	@Override
	public String toString() {
		return "User [account=" + account + ", createTime=" + createTime
				+ ", id=" + id + ", name=" + name + ", passwd=" + passwd
				+ ", roleId=" + roleId + ", roleName=" + roleName + ", status="
				+ status + "]";
	} 
	
 
	// drop table if exist t_user;
	// create table t_user(
	// id int auto_increment primary key,
	// account varchar(20) unique,
	// passwd varchar(20) not null,
	// emp_no varchar(5),
	// role_id int,
	// create_time date
	// )engine=Innodb;
}

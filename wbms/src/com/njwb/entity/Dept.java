package com.njwb.entity;

import java.util.Date;

public class Dept {
	
	

	
	/*
	 * 部门
	 * 
	 * 
	 */
	
	String deptNo;
	String deptName;
	String deptManEmpNo;
	String deptManEmpName;
	
	Integer deptEmpCnt;
	Date deptCreateTime;
	public String getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptManEmpName() {
		return deptManEmpName;
	}
	public void setDeptManEmpName(String deptManEmpName) {
		this.deptManEmpName = deptManEmpName;
	}
	public Integer getDeptEmpCnt() {
		return deptEmpCnt;
	}
	public void setDeptEmpCnt(Integer deptEmpCnt) {
		this.deptEmpCnt = deptEmpCnt;
	}
	public Date getDeptCreateTime() {
		return deptCreateTime;
	}
	public void setDeptCreateTime(Date deptCreateTime) {
		this.deptCreateTime = deptCreateTime;
	}
	public String getDeptManEmpNo() {
		return deptManEmpNo;
	}
	public void setDeptManEmpNo(String deptManEmpNo) {
		this.deptManEmpNo = deptManEmpNo;
	}
	@Override
	public String toString() {
		return "Dept [deptCreateTime=" + deptCreateTime + ", deptEmpCnt="
				+ deptEmpCnt + ", deptName=" + deptName + ", deptManEmpName="
				+ deptManEmpName + ", deptManEmpNo=" + deptManEmpNo
				+ ", deptNo=" + deptNo + "]";
	}
	 
	
	
	 
}


//-- 部门表
//-- 员工表
//drop table  if exists t_dept;
//create table t_dept(
//	dept_no varchar(10),
//	dept_name varchar(10),
//	dept_emp_cnt int,
//	dept_man_emp_id varchar(10),
//	dept_create_time date
//)engine=Innodb,  charset = utf8;








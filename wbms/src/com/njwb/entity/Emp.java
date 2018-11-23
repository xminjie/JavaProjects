package com.njwb.entity;

import java.util.Date;

public class Emp {
	/*
	 * 部门
	 */

	String empNo;
	String empName;
	String empEmail;
	String empPhone;
	String empPasswd;
	String empDeptNo;
	String empDeptName;

	Integer empSex;
	String empEdu;
	Integer empRoleId;

	Date empCreateTime;
	Date empEntryTime;

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}

	public String getEmpPasswd() {
		return empPasswd;
	}

	public void setEmpPasswd(String empPasswd) {
		this.empPasswd = empPasswd;
	}

	public String getEmpDeptNo() {
		return empDeptNo;
	}

	public void setEmpDeptNo(String empDeptNo) {
		this.empDeptNo = empDeptNo;
	}

	public String getEmpDeptName() {
		return empDeptName;
	}

	public void setEmpDeptName(String empDeptName) {
		this.empDeptName = empDeptName;
	}

	public Integer getEmpSex() {
		return empSex;
	}

	public void setEmpSex(Integer empSex) {
		this.empSex = empSex;
	}

	 
	public String getEmpEdu() {
		return empEdu;
	}

	public void setEmpEdu(String empEdu) {
		this.empEdu = empEdu;
	}

	public Integer getEmpRoleId() {
		return empRoleId;
	}

	public void setEmpRoleId(Integer empRoleId) {
		this.empRoleId = empRoleId;
	}

	public Date getEmpCreateTime() {
		return empCreateTime;
	}

	public void setEmpCreateTime(Date empCreateTime) {
		this.empCreateTime = empCreateTime;
	}

	public Date getEmpEntryTime() {
		return empEntryTime;
	}

	public void setEmpEntryTime(Date empEntryTime) {
		this.empEntryTime = empEntryTime;
	}

	@Override
	public String toString() {
		return "Emp [empCreateTime=" + empCreateTime + ", empDeptName="
				+ empDeptName + ", empDeptNo=" + empDeptNo + ", empEdu="
				+ empEdu + ", empEmail=" + empEmail + ", empEntryTime="
				+ empEntryTime + ", empName=" + empName + ", empNo=" + empNo
				+ ", empPasswd=" + empPasswd + ", empPhone=" + empPhone
				+ ", empRoleId=" + empRoleId + ", empSex=" + empSex + "]";
	}

	public Emp(String empNo, String empName, String empEmail, String empPhone,
			String empPasswd, String empDeptNo, String empDeptName,
			Integer empSex, String empEdu, Integer empRoleId, Date empEntryTime) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.empEmail = empEmail;
		this.empPhone = empPhone;
		this.empPasswd = empPasswd;
		this.empDeptNo = empDeptNo;
		this.empDeptName = empDeptName;
		this.empSex = empSex;
		this.empEdu = empEdu;
		this.empRoleId = empRoleId;
		this.empEntryTime = empEntryTime;
	}

	public Emp() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}

//
//
// -- 员工表
// drop table if exists t_emp;
// create table t_emp(
// emp_no varchar(10) primary key,
// emp_name varchar(10),
// emp_role_id int,
// emp_dept_no varchar(10),
// emp_sex int,
// emp_edu int,
// emp_email varchar(50),
// emp_phone varchar(20),
// emp_entry_time date,
// emp_create_time date,
// emp_passwd varchar(50)
// )engine=Innodb, charset = utf8;
//
// insert into t_emp
// values('e01','xmj',1,'A1',1,1,'xmj@qq.com','15715216166',now(),now(),'xmj');
// insert into t_emp
// values('e02','xzf',2,'A1',1,1,'xmj@qq.com','15715216166',now(),now(),'xzf');
// insert into t_emp
// values('e03','qss',3,'A1',1,1,'xmj@qq.com','15715216166',now(),now(),'qss');
// insert into t_emp values
// ('e04','lhh',4,'A1',1,1,'xmj@qq.com','15715216166',now(),now(),'lhh');
// select * from t_emp;
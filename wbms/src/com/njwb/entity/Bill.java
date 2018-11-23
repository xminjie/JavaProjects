package com.njwb.entity;

import java.util.Date;

public class Bill {
	
	
	 
	Integer billNo;
	String billDeptNo;
	String billDeptName;
	String billEmpNo;
	String billEmpName;
	Float billCnt;
	Integer billType;
	String billDetail;
	Date billTime;
	Integer billStatus;
	
	
	
	
	public Bill() {
		super();
	}

	public Bill(Integer billNo, String billDeptNo, String billDeptName,
			String billEmpNo, String billEmpName, Float billCnt,
			Integer billType, String billDetail, Date billTime,
			Integer billStauts) {
		super();
		this.billNo = billNo;
		this.billDeptNo = billDeptNo;
		this.billDeptName = billDeptName;
		this.billEmpNo = billEmpNo;
		this.billEmpName = billEmpName;
		this.billCnt = billCnt;
		this.billType = billType;
		this.billDetail = billDetail;
		this.billTime = billTime;
		this.billStatus = billStatus;
	}

	public Integer getBillNo() {
		return billNo;
	}

	public void setBillNo(Integer billNo) {
		this.billNo = billNo;
	}

	public String getBillDeptNo() {
		return billDeptNo;
	}

	public void setBillDeptNo(String billDeptNo) {
		this.billDeptNo = billDeptNo;
	}

	public String getBillDeptName() {
		return billDeptName;
	}

	public void setBillDeptName(String billDeptName) {
		this.billDeptName = billDeptName;
	}

	public String getBillEmpNo() {
		return billEmpNo;
	}

	public void setBillEmpNo(String billEmpNo) {
		this.billEmpNo = billEmpNo;
	}

	public String getBillEmpName() {
		return billEmpName;
	}

	public void setBillEmpName(String billEmpName) {
		this.billEmpName = billEmpName;
	}

	public Float getBillCnt() {
		return billCnt;
	}

	public void setBillCnt(Float billCnt) {
		this.billCnt = billCnt;
	}

	public Integer getBillType() {
		return billType;
	}

	public void setBillType(Integer billType) {
		this.billType = billType;
	}

	public String getBillDetail() {
		return billDetail;
	}

	public void setBillDetail(String billDetail) {
		this.billDetail = billDetail;
	}

	public Date getBillTime() {
		return billTime;
	}

	public void setBillTime(Date billTime) {
		this.billTime = billTime;
	}

	public Integer getBillStatus() {
		return billStatus;
	}

	public void setBillStatus(Integer billStatus) {
		this.billStatus = billStatus;
	}

	@Override
	public String toString() {
		return "Bill [billCnt=" + billCnt + ", billDeptName=" + billDeptName
				+ ", billDeptNo=" + billDeptNo + ", billDetail=" + billDetail
				+ ", billEmpName=" + billEmpName + ", billEmpNo=" + billEmpNo
				+ ", billNo=" + billNo + ", billStatus=" + billStatus
				+ ", billTime=" + billTime + ", billType=" + billType + "]";
	}
	 
//
//	-- 报销表
//
//	drop table  if exists t_bill;
//	create table t_bill(
//		bill_no int auto_increment primary key,
//		bill_dept_no varchar(20),
//		bill_emp_no varchar(20),
//		bill_cnt decimal,
//		bil_type int,
//		bill_detail varchar(50),
//		bill_time date,
//		bill_stauts int
//	)engine=Innodb,  charset = utf8;

}

package com.njwb.service;

import java.util.List;

import com.njwb.entity.Dept;

public interface DeptService {
	//部门表的增删改查
	List<Dept>  queryDept();
	Dept queryByDeptNo(String deptNo);
	Boolean deleteDeptByDeptNo(String deptNo);
	Boolean ModifiyDept(Dept dept);
	Boolean addDept(Dept dept);
	Boolean changeEmpCnt(Integer det, String deptNo);
}

package com.njwb.service;

import java.util.List;

import com.njwb.entity.Emp;

public interface EmpService {
	// 添加员工
	Boolean addEmp(Emp emp);

	// 删除员工
	Boolean deleteEmpByEmpNo(String empNo);

	// 修改员工
	Boolean modifyEmp(Emp emp);

	// 查询所有员工哦

	List<Emp> queryEmp();
	
	List<Emp> queryEmpByDeptNo(String deptNo);

	// 查询单个员工
	Emp queryEmpByEmpNo(String empNo);
}

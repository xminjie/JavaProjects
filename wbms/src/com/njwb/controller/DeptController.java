package com.njwb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.njwb.entity.Dept;
import com.njwb.entity.Emp;
import com.njwb.service.DeptService;
import com.njwb.service.EmpService;

public class DeptController {
	Logger log = Logger.getLogger(DeptController.class);

	DeptService deptService;

	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
	
	EmpService empService;

	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}
	public String depts(HttpServletRequest request, HttpServletResponse response) {
		List<Dept> deptList = deptService.queryDept();
		request.getSession().setAttribute("deptList", deptList);
		return "success";

	}

	public String deptAdd(HttpServletRequest request,
			HttpServletResponse response) {
		Dept dept = new Dept();
		dept.setDeptNo(request.getParameter("deptNo"));
		dept.setDeptName(request.getParameter("deptName"));
		log.info(dept + "添加");
		if (deptService.addDept(dept)) {
			return "success";
		}
		return "fail";

	}

	public String deptDelete(HttpServletRequest request,
			HttpServletResponse response) {
		String deptNo = request.getParameter("deptNo");
		if (deptService.deleteDeptByDeptNo(deptNo)) {
			return "success";
		}
		return "fail";

	}

	public String deptLook(HttpServletRequest request,
			HttpServletResponse response) {
		String deptNo = request.getParameter("deptNo");
		System.out.println(deptNo);
		Dept dept = deptService.queryByDeptNo(deptNo);
		request.getSession().setAttribute("dept",dept);
 //		
		
		List<Emp> empList = empService.queryEmpByDeptNo(deptNo);
//		List<Emp> empList = empService.queryEmp();
		System.out.println(deptNo+"-----------------------------");
		System.out.println(empList);
		request.getSession().setAttribute("empList", empList);
 		return "success";
	}
	public String deptModify(HttpServletRequest request,
			HttpServletResponse response) {
		Dept dept = new Dept();
		dept.setDeptNo(request.getParameter("deptNo"));
		dept.setDeptName(request.getParameter("deptName"));
		dept.setDeptManEmpNo(request.getParameter("deptManEmpNo"));
		log.info(dept + "添加");
		if (deptService.ModifiyDept(dept)) {
			return "success";
		}
		return "fail";
	}
	
	
}

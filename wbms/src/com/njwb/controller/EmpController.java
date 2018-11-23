package com.njwb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.njwb.entity.Dept;
import com.njwb.entity.Emp;
import com.njwb.service.DeptService;
import com.njwb.service.EmpService;
import com.njwb.util.DateUtil;

public class EmpController {

	DeptService deptService;
	
	EmpService empService;

	 
	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}

	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}

	
 
	// 查询所有员工
	public String emps(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(deptService);
		System.out.println(empService);
		List<Emp> empList = empService.queryEmp();
		request.setAttribute("empList", empList);
		return "success";
	}

	// 添加员工
	public String empDelete(HttpServletRequest request,
			HttpServletResponse response) {
		String empNo = request.getParameter("empNo");
		if (empService.deleteEmpByEmpNo(empNo)) {
			return "success";
		}
		return "false";

	}

	// 察看单个员工
	public String empLook(HttpServletRequest request,
			HttpServletResponse response) {
		List<Dept> deptList = deptService.queryDept();
		request.setAttribute("deptList", deptList);
		String empNo = request.getParameter("empNo");
		Emp emp = empService.queryEmpByEmpNo(empNo);
		request.setAttribute("emp", emp);
		return "success";
	}

	// 修改员工
	public String empModify(HttpServletRequest request,
			HttpServletResponse response) {
		Emp emp = new Emp();
		emp.setEmpNo(request.getParameter("empNo"));
		emp.setEmpName(request.getParameter("empName"));
		emp.setEmpSex(Integer.parseInt(request.getParameter("empSex")));
		emp.setEmpDeptNo(request.getParameter("empDeptNo"));
		emp.setEmpEmail(request.getParameter("empEmail"));
		emp.setEmpEdu(request.getParameter("empEdu"));
		emp.setEmpPhone(request.getParameter("empPhone"));
		emp.setEmpEntryTime(DateUtil.stringToDate(request.getParameter("entryTime")));
		empService.modifyEmp(emp);
		return "success";

	}

	public String empShowAdd(HttpServletRequest request,
			HttpServletResponse response) {
		List<Dept> deptList = deptService.queryDept();
		request.setAttribute("deptList", deptList);
		return "success";

	}

	
	public String empAdd(HttpServletRequest request,
			HttpServletResponse response) {
		Emp emp = new Emp();
		emp.setEmpNo(request.getParameter("empNo"));
		emp.setEmpName(request.getParameter("empName"));
		emp.setEmpSex(Integer.parseInt(request.getParameter("empSex")));
		emp.setEmpDeptNo(request.getParameter("empDeptNo"));
		emp.setEmpEmail(request.getParameter("empEmail"));
		emp.setEmpEdu(request.getParameter("empEdu"));
		emp.setEmpPhone("empPhone");
		emp.setEmpEntryTime(DateUtil.stringToDate(request.getParameter("entryTime")));
		if(empService.addEmp(emp)){
			return "success";
		}
		return "fail";
	}
}

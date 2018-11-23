package com.njwb.service.imp;

import java.util.List;

import com.njwb.dao.DeptDao;
import com.njwb.dao.EmpDao;
import com.njwb.dao.imp.DeptDaoImp;
import com.njwb.entity.Dept;
import com.njwb.entity.Emp;
import com.njwb.service.DeptService;

public class DeptServiceImp implements DeptService {
	
	DeptDao deptDao;
	EmpDao empDao;
	 
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}
 

	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}

	
	
	public Boolean ModifiyDept(Dept dept) {
		 
		return deptDao.ModifiyDept(dept);
	}

	public Boolean addDept(Dept dept) {
		// TODO Auto-generated method stub
		return deptDao.addDept(dept);
	}

	public Boolean changeEmpCnt(Integer det, String deptNo) {
		// TODO Auto-generated method stub
		return deptDao.changeEmpCnt(det, deptNo);
	}

	public Boolean deleteDeptByDeptNo(String deptNo) {
		// TODO Auto-generated method stub
		return deptDao.deleteDeptByDeptNo(deptNo);
	}

	public Dept queryByDeptNo(String deptNo) {
		// TODO Auto-generated method stub
		return deptDao.queryByDeptNo(deptNo);
	}

	public List<Dept> queryDept() {
		
		return deptDao.queryDept();
	}
	public static void main(String[] args) {
		Dept dept = new Dept();
		dept.setDeptNo("1");
		dept.setDeptManEmpNo("11111");
		dept.setDeptName("11111");
		dept.setDeptNo("A2");
		
	}

}

package com.njwb.service.imp;

import java.util.ArrayList;
import java.util.List;

import com.njwb.dao.EmpDao;
import com.njwb.entity.Emp;
import com.njwb.service.EmpService;

public class EmpServiceImp  implements EmpService{
	EmpDao empDao;
	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}

	public Boolean addEmp(Emp emp) {
 		return empDao.addEmp(emp);
	}

	public Boolean deleteEmpByEmpNo(String empNo) {
		// TODO Auto-generated method stub
		return empDao.deleteEmpByEmpNo(empNo);
	}

	public Boolean modifyEmp(Emp emp) {
		// TODO Auto-generated method stub
		return empDao.modifyEmp(emp);
	}

	public List<Emp> queryEmp() {
		// TODO Auto-generated method stub
		return empDao.queryEmp();
	}

	public Emp queryEmpByEmpNo(String empNo) {
		// TODO Auto-generated method stub
		return empDao.queryEmpByEmpNo(empNo);
	}

	public List<Emp> queryEmpByDeptNo(String deptNo) {
		List<Emp> empList = queryEmp();
		List<Emp> deptEmpList = new ArrayList<Emp>();
		for(Emp emp : empList){
			if(emp.getEmpDeptNo().equals(deptNo)){
				deptEmpList.add(emp);
			}
		}
		return deptEmpList;
	}
	
}

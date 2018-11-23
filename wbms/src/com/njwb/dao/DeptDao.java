package com.njwb.dao;

 import java.util.List;

import org.apache.log4j.Logger;

import com.njwb.entity.Dept;
import com.njwb.util.JDBCTemplate;
import com.njwb.util.JDBCUtil;
 
public interface DeptDao {
	//部门表的增删改查
	List<Dept>  queryDept();
	Dept queryByDeptNo(String deptNo);
	Boolean deleteDeptByDeptNo(String deptNo);
	Boolean ModifiyDept(Dept dept);
	Boolean addDept(Dept dept);
	Boolean changeEmpCnt(Integer det, String deptNo);
}

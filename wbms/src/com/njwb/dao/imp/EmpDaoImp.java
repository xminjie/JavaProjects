package com.njwb.dao.imp;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import com.njwb.dao.EmpDao;
import com.njwb.entity.Emp;
import com.njwb.rowmapper.imp.EmpRowMapper;
import com.njwb.util.JDBCTemplate;

public class EmpDaoImp  implements EmpDao {
	
	Logger log = Logger.getLogger(EmpDaoImp.class);
	
	
	JDBCTemplate jt = new JDBCTemplate();

	public Boolean addEmp(Emp emp) {
		//添加员工的时候，同时创建登录账户
		String sql1 = "insert into t_emp  values(?,?,? , ?,?,? , ?,?,?,now(),'xmj')";
		String sql2 = "insert into t_user (account, passwd, username, role_id, status, create_time) values (?,?,?,0,-1,now())";
		try {
			boolean b1 = jt.update(sql1, emp.getEmpNo()
					,emp.getEmpName()
					,emp.getEmpRoleId()
					
					,emp.getEmpDeptNo()
					,emp.getEmpSex()
					,emp.getEmpEdu()
					
					,emp.getEmpEmail()
					,emp.getEmpPhone()
					,emp.getEmpEntryTime()
					);
			
			boolean b2 = jt.update(sql2,  emp.getEmpNo(), emp.getEmpNo(),emp.getEmpName());
//			
//			
			return (b1 && b2);
		} catch (Exception e) {
			log.info("添加员工粗错",e);
			e.printStackTrace();
		}
		return false;
 	}

	public Boolean deleteEmpByEmpNo(String empNo) {
		//删除员工，其账户也一起删除
		String sql = "delete from t_emp where emp_no = ? ";
		String sql2 = "delete from t_user where account = ? ";
		try {
			jt.update(sql2, empNo);
			return jt.update(sql, empNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Boolean modifyEmp(Emp emp) {
		
		//修改员工后，检查所有部门，把主管被掉走的部门，设置其主管为空,并同步用户表
		String sqlExe = "update t_emp set emp_name = ?, emp_role_id = ?,  emp_dept_no = ?, emp_sex = ?, emp_edu = ?, emp_email = ?, emp_phone = ? ,emp_entry_time = ? where emp_no = ?";
		String sqlCheck = "update t_dept set dept_man_emp_no = null where dept_no != (select emp_dept_no from t_emp where dept_man_emp_no = emp_no)";
		String sqlCheck3 =  " update t_user set username = (select emp_name from t_emp where emp_no = account)";
		try {
			
			
			
			Boolean b1=  jt.update(sqlExe,
					emp.getEmpName()
					,emp.getEmpRoleId()
					
					,emp.getEmpDeptNo()
					,emp.getEmpSex()
					,emp.getEmpEdu()
					
					,emp.getEmpEmail()
					,emp.getEmpPhone()
					,emp.getEmpEntryTime()
					,emp.getEmpNo()
					);
			Boolean b2 = jt.update(sqlCheck);
			Boolean b3 = jt.update(sqlCheck3);
			return (b1 && b2 && b3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List<Emp> queryEmp() {
		String sql = " select *, (select dept_name  from t_dept where emp_dept_no = dept_no ) as emp_dept_name from t_emp";
		try {
			return jt.query(sql, new EmpRowMapper());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Emp queryEmpByEmpNo(String empNo) {
		String sql = " select *, (select dept_name  from t_dept where emp_dept_no = dept_no ) as emp_dept_name from t_emp where  emp_no  = ? ";
		try {
			return (Emp) jt.query(sql, new EmpRowMapper(),empNo).get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		Emp  emp = new Emp("te1", "nnnn", "nn", "A1",	 "testpasswd", "A1", "DeptName", 2, "本科", 1, new Date());
		EmpDaoImp empDaoImp = new EmpDaoImp();
//		System.out.println(empDaoImp.addEmp(emp));
//		System.out.println(empDaoImp.modifyEmp(emp));
//		System.out.println(empDaoImp.queryEmp());
		System.out.println(empDaoImp.queryEmpByEmpNo("e01"));
	}

}

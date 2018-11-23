package com.njwb.dao.imp;

import java.util.List;
import org.apache.log4j.Logger;

import com.njwb.dao.DeptDao;
import com.njwb.entity.Dept;
import com.njwb.rowmapper.imp.DeptRowMapper;
import com.njwb.util.JDBCTemplate;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class DeptDaoImp implements DeptDao {

	Logger log = Logger.getLogger(DeptDaoImp.class);

	JDBCTemplate jt = new JDBCTemplate();

	public Boolean ModifiyDept(Dept dept) {
		String sql = "update t_dept set dept_name  = ? , dept_man_emp_no = ?  where dept_no = ?";

		try {
			return jt.update(sql, dept.getDeptName(), dept.getDeptManEmpNo(),
					dept.getDeptNo());
		} catch (Exception e) {
			log.error("修改dept出错", e);
			e.printStackTrace();
			return false;
		}
	}

	public Boolean addDept(Dept dept) {
		String sql = "insert into t_dept values(?, ?, '暂无' ,now()) ";
		try {
			return jt.update(sql, dept.getDeptNo(), dept.getDeptName());
		} catch (Exception e) {
			log.error("添加部门失败dddddddddddddddadf", e);
			e.printStackTrace();
			return false;
		}
	}

	public Boolean deleteDeptByDeptNo(String deptNo) {
		String sql = "delete from t_dept where dept_no = ? and (select count(*) from t_emp where dept_no = emp_dept_no) = 0  ";
		try {
			return jt.update(sql, deptNo);
		} catch (Exception e) {
			log.error("删除部门失败dddddddddddddddadf", e);
			e.printStackTrace();
			return false;
		}
	}

	public List<Dept> queryDept() {
		String sql = "select dept_no, dept_name, dept_man_emp_no "
				+ ",(select emp_name from t_emp where dept_man_emp_no = emp_no ) as dept_man_emp_name,"
				+ "(select count(*) from t_emp where dept_no = emp_dept_no) as dept_emp_cnt , dept_create_time from t_dept";
		try {
			return jt.query(sql, new DeptRowMapper());
		} catch (Exception e) {
			log.error("dept查询出错");
			e.printStackTrace();
		}
		return null;
	}

	public Dept queryByDeptNo(String deptNo) {
		String sql = "select dept_no, dept_name, dept_man_emp_no "
				+ ",(select emp_name from t_emp where dept_man_emp_no = emp_no ) as dept_man_emp_name,"
				+ "(select count(*) from t_emp where dept_no = emp_dept_no) as dept_emp_cnt  , dept_create_time from t_dept where dept_no = ? ";
		try {
			return (Dept) jt.query(sql, new DeptRowMapper(), deptNo).get(0);
		} catch (Exception e) {
			log.error("dept查询出错");
			e.printStackTrace();
		}
		return null;
	}

	public Boolean changeEmpCnt(Integer det, String deptNo) {
		String sql = "update t_dept set dept_emp_cnt  = dept_emp_cnt + ?   where dept_no = ?";

		try {
			return jt.update(sql, det,deptNo);
		} catch (Exception e) {
			log.error("修改deptcnt出错", e);
			e.printStackTrace();
			return false;
		}
	}
	
	public static void main(String[] args) {
		Dept dept = new Dept();
		dept.setDeptNo("1");
		dept.setDeptManEmpNo("11111");
		dept.setDeptName("11111");
		dept.setDeptNo("A2");
		System.out.println(new DeptDaoImp().queryDept());
//		System.out.println(new DeptDaoImp().queryByDeptNo("A2"));
//		System.out.println(new DeptDaoImp().addDept(dept));
//		System.out.println(new DeptDaoImp().deleteDeptByDeptNo("A2"));
//		System.out.println(new DeptDaoImp().changeEmpCnt(1, "A2"));
	}

	

}

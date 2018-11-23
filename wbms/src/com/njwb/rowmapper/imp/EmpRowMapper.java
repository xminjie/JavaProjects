package com.njwb.rowmapper.imp;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.njwb.entity.Emp;
import com.njwb.rowmapper.RowMapper;

public class EmpRowMapper implements RowMapper {

	public Object getMapRow(ResultSet rs) {
		Emp emp = new Emp();
		try {
			emp.setEmpNo(rs.getString(1));
			emp.setEmpName(rs.getString(2));
			emp.setEmpRoleId(rs.getInt(3));

			emp.setEmpDeptNo(rs.getString(4));
			emp.setEmpSex(rs.getInt(5));
			emp.setEmpEdu(rs.getString(6));

			emp.setEmpEmail(rs.getString(7));
			emp.setEmpPhone(rs.getString(8));
			emp.setEmpEntryTime(rs.getDate(9));

			emp.setEmpCreateTime(rs.getDate(10));

			emp.setEmpPasswd(rs.getString(11));
			emp.setEmpDeptName(rs.getString(12));
			return emp;
		} catch (SQLException e) {
			System.out.println("EmpRow出错");
			e.printStackTrace();
		}

		return null;
	}

}

// mysql> select *, (select dept_name from t_dept where emp_dept_no = dept_no )
// as emp_dept_name from t_emp;
// +--------+----------+-------------+-------------+---------+---------+------------+-------------+----------------+-----------------+------------+---------------+
// | emp_no | emp_name | emp_role_id | emp_dept_no | emp_sex | emp_edu |
// emp_email | emp_phone | emp_entry_time | emp_create_time | emp_passwd |
// emp_dept_name |
// +--------+----------+-------------+-------------+---------+---------+------------+-------------+----------------+-----------------+------------+---------------+
// | e01 | xmj | 1 | A1 | 1 | 1 | xmj@qq.com | 157166 | 2018-11-13 | 2018-11-13
// | xmj | 人事 |
// | e02 | xzf | 2 | A2 | 1 | 1 | xmj@qq.com | 15700016166 | 2018-11-13 |
// 2018-11-13 | xzf | 采购 |
// | e03 | qss | 3 | A4 | 1 | 1 | xmj@qq.com | 15715216166 | 2018-11-13 |
// 2018-11-13 | qss | 财务 |
// | e04 | lhh | 4 | A1 | 1 | 1 | xmj@qq.com | 15715216166 | 2018-11-13 |
// 2018-11-13 | lhh | 人事 |
// +--------+----------+-------------+-------------+---------+---------+------------+-------------+----------------+-----------------+------------+---------------+

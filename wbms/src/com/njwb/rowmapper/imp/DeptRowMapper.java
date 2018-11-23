package com.njwb.rowmapper.imp;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.njwb.entity.Dept;
import com.njwb.rowmapper.RowMapper;

public class DeptRowMapper implements RowMapper {

	public Object getMapRow(ResultSet rs)   {
		
		Dept dept = new Dept();
		try {
			dept.setDeptNo(rs.getString(1));
			dept.setDeptName(rs.getString(2));
			
			dept.setDeptManEmpNo(rs.getString(3));
			dept.setDeptManEmpName(rs.getString(4));
			
			dept.setDeptEmpCnt(rs.getInt(5));
			dept.setDeptCreateTime(rs.getDate(6));
		} catch (SQLException e) {
			// TODO Auto-generated catch block\
			System.err.print("deptrowmapper出错");
			e.printStackTrace();
		}
 		return dept;
	}

}
////+---------+-----------+-----------------+-------------------+--------------+------------------+
//| dept_no | dept_name | dept_man_emp_id | dept_man_emp_name | dept_emp_cnt | dept_create_time |
//+---------+-----------+-----------------+-------------------+--------------+------------------+
//| A1      | 人事      | e02             | xzf               |            0 | 2018-11-13       |
//| A2      | 采购      | e01             | xmj               |            0 | 2018-11-13   
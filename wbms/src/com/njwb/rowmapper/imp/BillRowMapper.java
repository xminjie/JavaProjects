package com.njwb.rowmapper.imp;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.njwb.entity.Bill;
import com.njwb.rowmapper.RowMapper;

public class BillRowMapper  implements RowMapper{

	public Object getMapRow(ResultSet rs) {
		Bill bill = new Bill();
		try {
			bill.setBillNo(rs.getInt(1));
			bill.setBillDeptNo(rs.getString(2));
			bill.setBillEmpNo(rs.getString(3));
			bill.setBillCnt(rs.getFloat(4));
			bill.setBillType(rs.getInt(5));
			bill.setBillDetail(rs.getString(6));
			bill.setBillTime(rs.getDate(7));
			bill.setBillStatus(rs.getInt(8));
			bill.setBillDeptName(rs.getString(9));
			bill.setBillEmpName(rs.getString(10));
			return bill;
		} catch (SQLException e) {
			System.out.println("账单rowmapper出错");
			e.printStackTrace();
		}
		return null;
	}

}

//
//+---------+--------------+-------------+----------+----------+-----------------------+------------+-------------+----------------+---------------+
//| bill_no | bill_dept_no | bill_emp_no | bill_cnt | bil_type | bill_detail           | bill_time  | bill_status | bill_dept_name | bill_emp_name |
//+---------+--------------+-------------+----------+----------+-----------------------+------------+-------------+----------------+---------------+
//|       1 | A1           | e01         |       30 |        1 | 打的 sdf20 块         | 2015-09-09 |          -1 | 人事           | 谢民皆        |
//|       2 | A1           | e01         |       20 |        1 | 打的sdff 20 块        | 2015-09-09 |           1 | 人事           | 谢民皆        |
//|       3 | A2           | e02         |       50 |        2 | 打的fdshrtf 20 块     | 2015-09-09 |          -1 | 采购           | 徐子峰        |
//|       4 | A3           | e03         |       10 |        1 | 打的 fh20 块          | 2015-09-09 |          -1 | 销售           | 美老师        |
//|       5 | A4           | e05         |       80 |        3 | 打的 jhhthfghh0 块    | 2015-09-09 |           1 | 财务           | 唐拥拥        |
//|       6 | A1           | e01         |       20 |        1 | 打的 20hgffgh 块      | 2015-09-09 |          -1 | 人事           | 谢民皆        |
//+---------+--------------+-------------+----------+----------+-----------------------+------------+-------------+----------------+---------------+

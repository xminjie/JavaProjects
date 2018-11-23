package com.njwb.dao.imp;

import java.util.Date;
import java.util.List;

import com.njwb.dao.BillDao;
import com.njwb.entity.Bill;
import com.njwb.rowmapper.imp.BillRowMapper;
import com.njwb.util.JDBCTemplate;

public class BillDaoImp implements BillDao {
	JDBCTemplate jt = new JDBCTemplate();

	public boolean AddBill(Bill bill) {
		String sql = "insert into t_bill (bill_dept_no, bill_emp_no,bill_cnt,bill_type,bill_detail,bill_time,bill_status) values "
				+ " (?,?,?,?,?,?,?)";

		try {
			jt.update(sql, bill.getBillDeptNo(), bill.getBillEmpNo(), bill
					.getBillCnt(), bill.getBillType(), bill.getBillDetail(),
					bill.getBillTime(), bill.getBillStatus());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List<Bill> queryAllBill() {
		String sql = "select *  ,"
				+ "(select dept_name from t_dept where dept_no = bill_dept_no) as bill_dept_name,"
				+ "(select emp_name from t_emp where emp_no = bill_emp_no)  as bill_emp_name from t_bill";
		try {
			return jt.query(sql, new BillRowMapper());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean ModifyBillByBillNo(Bill bill) {
		System.out.println("===+++++++++" + bill);
		
		
		String sql = "update t_bill set "
				+ " bill_dept_no = ?, bill_emp_no = ? , bill_cnt = ?, bill_type = ?,"
				+ " bill_detail = ?, bill_time = ?, bill_status = ? where bill_no = ? ";

		try {
			return jt.update(sql, bill.getBillDeptNo(), bill.getBillEmpNo(),
					bill.getBillCnt(), bill.getBillType(),
					bill.getBillDetail(), bill.getBillTime(), bill
							.getBillStatus(), bill.getBillNo());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

		// bill_no int auto_increment primary key,
		// bill_dept_no varchar(20),
		// bill_emp_no varchar(20),
		// bill_cnt float,
		// bil_type int,
		// bill_detail varchar(50),
		// bill_time date,
		// bill_status int

	}

	public boolean deleteBillByBillNo(Integer billNo) {
		String sql = "delete from t_bill where bill_no = ? and bill_status = -1 ";

		try {
			return jt.update(sql, billNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List<Bill> queryAccessBill() {
		String sql = "select *  ,"
				+ "(select dept_name from t_dept where dept_no = bill_dept_no) as bill_dept_name,"
				+ "(select emp_name from t_emp where emp_no = bill_emp_no)  as bill_emp_name from t_bill where bill_status = 1";
		try {
			return jt.query(sql, new BillRowMapper());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Bill queryBillBYBillNo(Integer billNo) {
		String sql = "select *  ,"
				+ "(select dept_name from t_dept where dept_no = bill_dept_no) as bill_dept_name,"
				+ "(select emp_name from t_emp where emp_no = bill_emp_no)  as bill_emp_name from t_bill where bill_no = ? ";
		try {
			return (Bill) jt.query(sql, new BillRowMapper(), billNo).get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		Bill bill = new Bill(1151, "f", "f", "df", "df", new Float(4.9), 1,
				"hhhhhh", new Date(), -1);
		BillDaoImp billDaoImp = new BillDaoImp();
		// billDaoImp.AddBill(bill);
//		System.out.println(billDaoImp.queryAllBill());
		// System.out.println(billDaoImp.deleteBillByBillNo(1));
		// System.out.println(billDaoImp.ModifyBillByBillNo(bill));
		System.out.println(billDaoImp.queryBillBYBillNo(1));

	}

}

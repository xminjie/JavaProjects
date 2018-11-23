package com.njwb.service.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.njwb.dao.BillDao;
import com.njwb.dao.DeptDao;
import com.njwb.dao.EmpDao;
import com.njwb.entity.Bill;
import com.njwb.entity.Dept;
import com.njwb.entity.Emp;
import com.njwb.entity.StaBill;
import com.njwb.entity.StaCond;
import com.njwb.service.BillService;
import com.sun.faces.renderkit.html_basic.ListboxRenderer;

public class BillServiceImp implements BillService {

	BillDao billDao;
	EmpDao empDao;
	DeptDao deptDao;

	public EmpDao getEmpDao() {
		return empDao;
	}

	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}

	public DeptDao getDeptDao() {
		return deptDao;
	}

	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}

	public BillDao getBillDao() {
		return billDao;
	}

	public void setBillDao(BillDao billDao) {
		this.billDao = billDao;
	}

	public boolean AddBill(Bill bill) {

		// System.out.println(bill +
		// "-----------------------------------------------------------------------");
		//		
		// System.out.println(bill.getBillEmpNo() +
		// "================++++++++++++++++++++++++++++++++++");;

		Emp emp = empDao.queryEmpByEmpNo(bill.getBillEmpNo());

		// System.out.println(emp + "=========================");

		Dept dept = deptDao.queryByDeptNo(emp.getEmpDeptNo());
		//		
		//		
		bill.setBillDeptNo(dept.getDeptNo());
		bill.setBillDeptName(dept.getDeptName());
		//		
		bill.setBillEmpName(emp.getEmpName());

		return billDao.AddBill(bill);
	}

	public boolean deleteBillByBillNo(Integer billNo) {
		// TODO Auto-generated method stub
		return billDao.deleteBillByBillNo(billNo);
	}

	public List<Bill> queryAccessBill() {
		// TODO Auto-generated method stub
		return billDao.queryAccessBill();
	}

	public List<Bill> queryAllBill() {
		// TODO Auto-generated method stub
		return billDao.queryAllBill();
	}

	public boolean ModifyBillByBillNo(Bill bill) {

		Emp emp = empDao.queryEmpByEmpNo(bill.getBillEmpNo());

		// System.out.println(emp + "=========================");

		Dept dept = deptDao.queryByDeptNo(emp.getEmpDeptNo());
		//		
		//		
		bill.setBillDeptNo(dept.getDeptNo());
		bill.setBillDeptName(dept.getDeptName());
		//		
		bill.setBillEmpName(emp.getEmpName());
		// TODO Auto-generated method stub
		return billDao.ModifyBillByBillNo(bill);
	}

	public Bill queryBillBYBillNo(Integer billNo) {
		// TODO Auto-generated method stub
		return billDao.queryBillBYBillNo(billNo);
	}

	public List<StaBill> queryStaBillByStaCond(StaCond staCond) {
		 if(staCond.getSelfDefine() == -1 ){
		 Date dateStart = new Date();
		 Date dateEnd = new Date();
					
		 dateStart.setYear(staCond.getYear()-1900);
		 dateStart.setMonth(1);
		 dateStart.setDate(1);
					
		 dateEnd.setYear(staCond.getYear()-1900);
		 dateEnd.setMonth(12);
		 dateEnd.setDate(31);
					
		  if(staCond.getYear() == 0){
		  dateStart.setYear(1);
		  dateEnd.setYear(200);
		  }
		 staCond.setDateStart(dateStart);
		 staCond.setDateEnd(dateEnd);
		 }

		System.out.println("66666666666666666666" + staCond.getDateStart()
				+ "+++++++++" + staCond.getDateEnd());

		List<Bill> billList = queryAccessBill();

		HashMap<String, StaBill> staBilHashMap = new HashMap<String, StaBill>();

		List<Dept> deptList = deptDao.queryDept();

		for (Dept dept : deptList) {
			StaBill staBill = new StaBill();
			staBill.setDeptNo(dept.getDeptNo());
			staBill.setDeptName(dept.getDeptName());
			staBilHashMap.put(dept.getDeptNo(), staBill);
		}
		//		
		for (Bill bill : billList) {
			if (bill.getBillTime().compareTo(staCond.getDateStart()) >= 0 &&  bill.getBillTime().compareTo(staCond.getDateEnd()) <= 0) {
				StaBill staBill = staBilHashMap.get(bill.getBillDeptNo());
				System.out.println(" -------------" + staBill);

				if (bill.getBillTime().getMonth() == 1 - 1) {
					staBill.setSum1(staBill.getSum1() + bill.getBillCnt());
					staBill.setSum13(staBill.getSum13() + bill.getBillCnt());
				} else if (bill.getBillTime().getMonth() == 2 - 1) {
					staBill.setSum2(staBill.getSum2() + bill.getBillCnt());
					staBill.setSum13(staBill.getSum13() + bill.getBillCnt());
				} else if (bill.getBillTime().getMonth() == 3 - 1) {
					staBill.setSum3(staBill.getSum3() + bill.getBillCnt());
					staBill.setSum13(staBill.getSum13() + bill.getBillCnt());
				} else if (bill.getBillTime().getMonth() == 4 - 1) {
					staBill.setSum4(staBill.getSum4() + bill.getBillCnt());
					staBill.setSum46(staBill.getSum46() + bill.getBillCnt());
				} else if (bill.getBillTime().getMonth() == 5 - 1) {
					staBill.setSum5(staBill.getSum5() + bill.getBillCnt());
					staBill.setSum46(staBill.getSum46() + bill.getBillCnt());
				} else if (bill.getBillTime().getMonth() == 6 - 1) {
					staBill.setSum6(staBill.getSum6() + bill.getBillCnt());
					staBill.setSum46(staBill.getSum46() + bill.getBillCnt());
				} else if (bill.getBillTime().getMonth() == 7 - 1) {
					staBill.setSum7(staBill.getSum7() + bill.getBillCnt());
					staBill.setSum79(staBill.getSum79() + bill.getBillCnt());
				} else if (bill.getBillTime().getMonth() == 8 - 1) {
					staBill.setSum8(staBill.getSum8() + bill.getBillCnt());
					staBill.setSum79(staBill.getSum79() + bill.getBillCnt());
				} else if (bill.getBillTime().getMonth() == 9 - 1) {
					staBill.setSum9(staBill.getSum9() + bill.getBillCnt());
					staBill.setSum79(staBill.getSum79() + bill.getBillCnt());
				} else if (bill.getBillTime().getMonth() == 10 - 1) {
					staBill.setSum10(staBill.getSum10() + bill.getBillCnt());
					staBill
							.setSum1012(staBill.getSum1012()
									+ bill.getBillCnt());
				} else if (bill.getBillTime().getMonth() == 11 - 1) {
					staBill.setSum11(staBill.getSum11() + bill.getBillCnt());
					staBill
							.setSum1012(staBill.getSum1012()
									+ bill.getBillCnt());
				} else if (bill.getBillTime().getMonth() == 12 - 1) {
					staBill.setSum12(staBill.getSum12() + bill.getBillCnt());
					staBill
							.setSum1012(staBill.getSum1012()
									+ bill.getBillCnt());
				}
				// System.out.println("0000" + bill.getBillCnt());;
				// System.out.println("0000" + staBill.getSum());;
				// System.out.println("8888" + "dfs" + bill);
				// staBill.setSum(5.2);
				staBill.setSum(staBill.getSum() + bill.getBillCnt());
			}
			System.out.println("7777" + bill.getBillTime().getYear());
		}

		List<StaBill> staBillList = new ArrayList<StaBill>();
		for (Dept dept : deptList) {
			staBillList.add(staBilHashMap.get(dept.getDeptNo()));
		}
		return staBillList;
		// return null;

	}

}

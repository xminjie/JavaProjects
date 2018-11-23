package com.njwb.dao;

import java.util.List;

import com.njwb.entity.Bill;

public interface BillDao {
	
	List<Bill> queryAllBill();
	List<Bill> queryAccessBill();
	Bill queryBillBYBillNo(Integer billNo);
	boolean deleteBillByBillNo(Integer billNo);
	boolean ModifyBillByBillNo(Bill bill);
	boolean AddBill(Bill bill);
	

}

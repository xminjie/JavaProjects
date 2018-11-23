package com.njwb.service;

import java.util.List;

import com.njwb.entity.Bill;
import com.njwb.entity.StaBill;
import com.njwb.entity.StaCond;

public interface BillService {
	List<Bill> queryAllBill();

	List<Bill> queryAccessBill();

	boolean deleteBillByBillNo(Integer billNo);

	boolean ModifyBillByBillNo(Bill bill);

	boolean AddBill(Bill bill);

	Bill queryBillBYBillNo(Integer billNo);
	
	List<StaBill> queryStaBillByStaCond(StaCond staCond);
	

}

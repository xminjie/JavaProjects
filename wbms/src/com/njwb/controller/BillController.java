package com.njwb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.njwb.entity.Bill;
import com.njwb.entity.StaBill;
import com.njwb.entity.StaCond;
import com.njwb.service.BillService;
import com.njwb.util.DateUtil;

public class BillController {

	BillService billService;

	public void setBillService(BillService billService) {
		this.billService = billService;
	}

	public String bills(HttpServletRequest request, HttpServletResponse response) {

		List<Bill> billList = billService.queryAllBill();
		//		
		request.setAttribute("billList", billList);

		System.out.println(billService + "dfgdssdg-==================");

		return "success";

	}

	public String billAdd(HttpServletRequest request,
			HttpServletResponse response) {

		Bill bill = new Bill();
		bill.setBillEmpNo(request.getParameter("empNo"));
		bill.setBillType(Integer.parseInt(request.getParameter("billType")));
		bill.setBillCnt(Float.parseFloat(request.getParameter("billCnt")));
		bill.setBillDetail(request.getParameter("billDetail"));
		bill.setBillTime(DateUtil
				.stringToDate(request.getParameter("billTime")));
		bill
				.setBillStatus(Integer.parseInt(request
						.getParameter("billStatus")));
		billService.AddBill(bill);

		// System.out.println(bill);

		return "success";

	}

	public String billDelete(HttpServletRequest request,
			HttpServletResponse response) {

		Integer billNo = Integer.parseInt(request.getParameter("billNo"));

		billService.deleteBillByBillNo(billNo);

		return "success";

	}

	public String billLook(HttpServletRequest request,
			HttpServletResponse response) {

		Integer billNo = Integer.parseInt(request.getParameter("billNo"));

		Bill bill = billService.queryBillBYBillNo(billNo);

		request.setAttribute("bill", bill);

		return "success";

	}

	public String billModify(HttpServletRequest request,
			HttpServletResponse response) {

		Bill bill = new Bill();
		bill.setBillNo(Integer.parseInt(request.getParameter("billNo")));
		bill.setBillEmpNo(request.getParameter("empNo"));
		bill.setBillType(Integer.parseInt(request.getParameter("billType")));
		bill.setBillCnt(Float.parseFloat(request.getParameter("billCnt")));
		bill.setBillDetail(request.getParameter("billDetail"));
		bill.setBillTime(DateUtil
				.stringToDate(request.getParameter("billTime")));
		bill
				.setBillStatus(Integer.parseInt(request
						.getParameter("billStatus")));
		System.out.println(bill);
		billService.ModifyBillByBillNo(bill);


		return "success";

	}

	public String sta(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			
			
			
			StaCond staCond = new StaCond();
			try {
				staCond.setSelfDefine(Integer.parseInt(request
						.getParameter("selfDefine")));
			} catch (Exception e) {
				staCond.setSelfDefine(-1);
			}
			staCond.setYear(Integer.parseInt(request.getParameter("year")));
			staCond.setSeaMon(Integer.parseInt(request.getParameter("seaMon")));
			staCond.setDateStart(DateUtil.stringToDate(request
					.getParameter("dateStart")));
			staCond.setDateEnd(DateUtil.stringToDate(request
					.getParameter("dateEnd")));
			System.out.println("888888888888888888"+staCond);
			
			request.setAttribute("staCond", staCond);
			
			
			
//			List<StaBill> Bi = billService.queryAccessBill();
			

			
			
			
			
			
			
			
			
			request.setAttribute("staBillList", billService.queryStaBillByStaCond(staCond));
			
			System.out.println("+++++++" + billService.queryStaBillByStaCond(staCond));
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "success";

	}

}

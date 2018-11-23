package com.njwb.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

 
public class DateUtil {
	public static Date stringToDate(String s) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		
		
		try {
			return df.parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
	}
	
	
	
	
	public static void main(String[] args) {
		System.out.println(DateUtil.stringToDate("2017-2-03").toString());
	}

}

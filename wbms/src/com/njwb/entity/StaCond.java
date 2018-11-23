package com.njwb.entity;

import java.text.DateFormat;
import java.util.Date;

public class StaCond {
	
	String deptNo;
	Integer selfDefine;
	Integer year;
	Integer SeaMon;
	Date dateStart;
	Date dateEnd;
	
	
	public Integer getSelfDefine() {
		return selfDefine;
	}
	public void setSelfDefine(Integer selfDefine) {
		this.selfDefine = selfDefine;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getSeaMon() {
		return SeaMon;
	}
	public void setSeaMon(Integer seaMon) {
		SeaMon = seaMon;
	}
	public Date getDateStart() {
		return dateStart;
	}
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}
	public Date getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
	@Override
	public String toString() {
		return "StaCond [SeaMon=" + SeaMon + ", dateEnd=" + dateEnd
				+ ", dateStart=" + dateStart + ", selfDefine=" + selfDefine
				+ ", year=" + year + "]";
	}
	
	
	

}

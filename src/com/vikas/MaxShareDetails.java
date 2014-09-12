package com.vikas;

/**
 * MaxShareDetails class stores the information of  maxShareValue,companyName,year and month
 * Negative maxShareValue,year,month indicates that share data is unavailable
 */

public class MaxShareDetails {
	private String companyName=null;
	private int year=-1;
	private String month=null;
	private double maxShareValue=-1;
	
	//getters and setters method
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public double getMaxShareValue() {
		return maxShareValue;
	}
	public void setMaxShareValue(double maxShareValue) {
		this.maxShareValue = maxShareValue;
	}
	
	
	
}

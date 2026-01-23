package com.wipro.ptpms.entity;

public class UsageLog {
	private String logId;
	private String passId;
	private String date;
	private String routeName;
	private String usageDate;
	
	
	 public UsageLog(String logId, String passId,
             String usageDate, String routeName) {
 this.logId = logId;
 this.passId = passId;
 this.usageDate = usageDate;
 this.routeName = routeName;
}
	 
	public String getLogId() {
		return logId;
	}
	public void setLogId(String logId) {
		this.logId = logId;
	}
	public String getPassId() {
		return passId;
	}
	public void setPassId(String passId) {
		this.passId = passId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	

}

package com.PersonalInventorySystem.bean;

import java.sql.Date;

public class IncomeBean {
	
    private int inc_id;
    private String inc_ac;
    private int userid;
    private double amount;
	private String transaction_date;
    private String receivby;
    private String remark;
    private int inc_catid;
    
    public int getInc_id() {
		return inc_id;
	}
	public void setInc_id(int inc_id) {
		this.inc_id = inc_id;
	}
	public String getInc_ac() {
		return inc_ac;
	}
	public void setInc_ac(String inc_ac) {
		this.inc_ac = inc_ac;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTransaction_date() {
		return transaction_date;
	}
	public void setTransaction_date(String transaction_date) {
		this.transaction_date = transaction_date;
	}
	public String getReceivby() {
		return receivby;
	}
	public void setReceivby(String receivby) {
		this.receivby = receivby;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getInc_catid() {
		return inc_catid;
	}
	public void setInc_catid(int inc_catid) {
		this.inc_catid = inc_catid;
	}

}

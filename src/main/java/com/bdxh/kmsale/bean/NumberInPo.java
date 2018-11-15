package com.bdxh.kmsale.bean;

import java.io.Serializable;
import java.util.Date;

public class NumberInPo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1833987519199037690L;
	
	private String svcNumber;
	private String simNumber;
	private Date insertDate;
	private String operId;
	private String branchId;
	private String returnReason;
	
	private String startTime;
	private String endTime;

	public void setSvcNumber(String svcNumber) {
		this.svcNumber = svcNumber;
	}

	public String getSvcNumber() {
		return this.svcNumber;
	}

	public void setSimNumber(String simNumber) {
		this.simNumber = simNumber;
	}

	public String getSimNumber() {
		return this.simNumber;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public Date getInsertDate() {
		return this.insertDate;
	}

	public void setOperId(String operId) {
		this.operId = operId;
	}

	public String getOperId() {
		return this.operId;
	}

	public String getBranchId() {
		return this.branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getReturnReason() {
		return this.returnReason;
	}

	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}

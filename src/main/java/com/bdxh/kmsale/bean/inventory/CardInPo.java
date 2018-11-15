package com.bdxh.kmsale.bean.inventory;

import java.util.Date;

public class CardInPo {

	private String simNumber;
	private Date insertDate;
	private String operId;
	private String branchId;
	private String returnReason;

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
}

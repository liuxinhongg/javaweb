package com.bdxh.kmsale.bean.code;

import java.io.Serializable;
import java.util.Date;

public class CommTelBillPo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5501511085380225706L;

	private Double allowance;
	
	private Integer commMin;
	
	private Integer commMax;
	
	private String operId;
	
	private Integer status;
	
	private Date createDate;
	
	private Integer telBillId;
	
	private Integer ord;

	public Double getAllowance() {
		return allowance;
	}

	public void setAllowance(Double allowance) {
		this.allowance = allowance;
	}

	public Integer getCommMin() {
		return commMin;
	}

	public void setCommMin(Integer commMin) {
		this.commMin = commMin;
	}

	public Integer getCommMax() {
		return commMax;
	}

	public void setCommMax(Integer commMax) {
		this.commMax = commMax;
	}

	public String getOperId() {
		return operId;
	}

	public void setOperId(String operId) {
		this.operId = operId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getTelBillId() {
		return telBillId;
	}

	public void setTelBillId(Integer telBillId) {
		this.telBillId = telBillId;
	}

	public Integer getOrd() {
		return ord;
	}

	public void setOrd(Integer ord) {
		this.ord = ord;
	}
}

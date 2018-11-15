package com.bdxh.kmsale.bean.code;

import java.io.Serializable;
import java.util.Date;

public class CommNewAgentPo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2206838652807961332L;

	private String codeId;
	
	private String codeDesc;
	
	private Integer status;
	
	private Date createDate;
	
	private String operId;
	
	private Double totalMoney;
	
	private Double firstMMoney;
	
	private Double secondMMoney;
	
	private Double lastMMoney;

	public String getCodeId() {
		return codeId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	public String getCodeDesc() {
		return codeDesc;
	}

	public void setCodeDesc(String codeDesc) {
		this.codeDesc = codeDesc;
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

	public String getOperId() {
		return operId;
	}

	public void setOperId(String operId) {
		this.operId = operId;
	}

	public Double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public Double getFirstMMoney() {
		return firstMMoney;
	}

	public void setFirstMMoney(Double firstMMoney) {
		this.firstMMoney = firstMMoney;
	}

	public Double getSecondMMoney() {
		return secondMMoney;
	}

	public void setSecondMMoney(Double secondMMoney) {
		this.secondMMoney = secondMMoney;
	}

	public Double getLastMMoney() {
		return lastMMoney;
	}

	public void setLastMMoney(Double lastMMoney) {
		this.lastMMoney = lastMMoney;
	}
}

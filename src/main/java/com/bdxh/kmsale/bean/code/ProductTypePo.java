package com.bdxh.kmsale.bean.code;

import java.io.Serializable;
import java.util.Date;

public class ProductTypePo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8991968887050837538L;

	private String codeId;
	
	private String codeDesc;
	
	private Integer status;
	
	private Integer ord;
	
	private Date createDate;
	
	private Double onceRate;
	
	private String operId; 

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

	public Integer getOrd() {
		return ord;
	}

	public void setOrd(Integer ord) {
		this.ord = ord;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Double getOnceRate() {
		return onceRate;
	}

	public void setOnceRate(Double onceRate) {
		this.onceRate = onceRate;
	}

	public String getOperId() {
		return operId;
	}

	public void setOperId(String operId) {
		this.operId = operId;
	}
}

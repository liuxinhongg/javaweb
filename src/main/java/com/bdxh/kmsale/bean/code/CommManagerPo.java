package com.bdxh.kmsale.bean.code;

import java.io.Serializable;
import java.util.Date;

public class CommManagerPo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 365797321350549145L;
	
	private String codeId;
	
    private Integer status;
	
	private Integer ord;
	
	private Date createDate;
	
    private Double commMin;
	
	private Double commMax;
	
	private String operId;
	
	private Double commRate;

	public String getCodeId() {
		return codeId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
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

	public Double getCommMin() {
		return commMin;
	}

	public void setCommMin(Double commMin) {
		this.commMin = commMin;
	}

	public Double getCommMax() {
		return commMax;
	}

	public void setCommMax(Double commMax) {
		this.commMax = commMax;
	}

	public String getOperId() {
		return operId;
	}

	public void setOperId(String operId) {
		this.operId = operId;
	}

	public Double getCommRate() {
		return commRate;
	}

	public void setCommRate(Double commRate) {
		this.commRate = commRate;
	}
}

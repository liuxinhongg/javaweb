package com.bdxh.kmsale.bean.code;

import java.io.Serializable;
import java.util.Date;

public class CommCallPo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3554403086249698336L;

	private String codeId;
	
	private String codeDesc;
	
	private Integer status;
	
	private Integer ord;
	
	private Date createDate;
	
	private Double firstYRate;
	
	private Double secondYRate;
	
	private Double commMin;
	
	private Double commMax;
	
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

	public Double getFirstYRate() {
		return firstYRate;
	}

	public void setFirstYRate(Double firstYRate) {
		this.firstYRate = firstYRate;
	}

	public Double getSecondYRate() {
		return secondYRate;
	}

	public void setSecondYRate(Double secondYRate) {
		this.secondYRate = secondYRate;
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
}

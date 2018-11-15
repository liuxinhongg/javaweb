package com.bdxh.kmsale.bean.code;

import java.io.Serializable;
import java.util.Date;

public class CommContributionPo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -911742223144255395L;

    private String codeId;
	
	private String codeDesc;
	
	private Integer status;
	
	private Integer ord;
	
	private Date createDate;
	
	private String operId;
	
	private Double commMin;
	
	private Double commContribution;

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

	public String getOperId() {
		return operId;
	}

	public void setOperId(String operId) {
		this.operId = operId;
	}

	public Double getCommMin() {
		return commMin;
	}

	public void setCommMin(Double commMin) {
		this.commMin = commMin;
	}

	public Double getCommContribution() {
		return commContribution;
	}

	public void setCommContribution(Double commContribution) {
		this.commContribution = commContribution;
	}
}

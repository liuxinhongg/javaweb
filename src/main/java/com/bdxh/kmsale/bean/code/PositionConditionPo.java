package com.bdxh.kmsale.bean.code;

import java.io.Serializable;
import java.util.Date;

public class PositionConditionPo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5484359621265473735L;
	
	private Integer conditionId;
	
	private String conditionName;
	
	private Double conditionX;
	
	private Double conditionY;
	
	private Integer conditionOrd;
	
	private Date conditionDate;
	
	private String operId;
	
	private Integer status;
	
	private String conditionDesc;
	
	private Integer conditionType;

	public Integer getConditionId() {
		return conditionId;
	}

	public void setConditionId(Integer conditionId) {
		this.conditionId = conditionId;
	}

	public String getConditionName() {
		return conditionName;
	}

	public void setConditionName(String conditionName) {
		this.conditionName = conditionName;
	}

	public Double getConditionX() {
		return conditionX;
	}

	public void setConditionX(Double conditionX) {
		this.conditionX = conditionX;
	}

	public Double getConditionY() {
		return conditionY;
	}

	public void setConditionY(Double conditionY) {
		this.conditionY = conditionY;
	}

	public Integer getConditionOrd() {
		return conditionOrd;
	}

	public void setConditionOrd(Integer conditionOrd) {
		this.conditionOrd = conditionOrd;
	}

	public Date getConditionDate() {
		return conditionDate;
	}

	public void setConditionDate(Date conditionDate) {
		this.conditionDate = conditionDate;
	}

	public String getOperId() {
		return operId;
	}

	public void setOperId(String operId) {
		this.operId = operId;
	}

	public String getConditionDesc() {
		return conditionDesc;
	}

	public void setConditionDesc(String conditionDesc) {
		this.conditionDesc = conditionDesc;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getConditionType() {
		return conditionType;
	}

	public void setConditionType(Integer conditionType) {
		this.conditionType = conditionType;
	}
}

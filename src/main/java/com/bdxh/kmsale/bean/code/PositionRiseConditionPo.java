package com.bdxh.kmsale.bean.code;

import java.io.Serializable;
import java.util.Date;

public class PositionRiseConditionPo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7200698907135900971L;

	private Integer conditionId;
	
	private Integer positionId;
	
	private String positionName;
	
	private Integer needPositionId;
	
	private String needPositionName;
	
	private Integer standardType;//基础条件类型 1、评比合格 2、拥有个人销售小组
	
	private Integer highType;//高级条件类型 1、拥有高级直接销售小组数 2、持续3个月话费总额 3、当月产生话费总量
	
	private Double highValueMin;//高级条件满足条件值最低值
	
	private Double highValueMax;//高级条件满足条件值最高值
	
	private Integer conditionOrd;//排序
	
	private Integer status;//0 无效 1 有效
	
	private Date conditionDate;//设置时间
	
	private String operId;//操作人

	public Integer getConditionId() {
		return conditionId;
	}

	public void setConditionId(Integer conditionId) {
		this.conditionId = conditionId;
	}

	public Integer getPositionId() {
		return positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public Integer getNeedPositionId() {
		return needPositionId;
	}

	public void setNeedPositionId(Integer needPositionId) {
		this.needPositionId = needPositionId;
	}

	public String getNeedPositionName() {
		return needPositionName;
	}

	public void setNeedPositionName(String needPositionName) {
		this.needPositionName = needPositionName;
	}

	public Integer getStandardType() {
		return standardType;
	}

	public void setStandardType(Integer standardType) {
		this.standardType = standardType;
	}

	public Integer getHighType() {
		return highType;
	}

	public void setHighType(Integer highType) {
		this.highType = highType;
	}

	public Double getHighValueMin() {
		return highValueMin;
	}

	public void setHighValueMin(Double highValueMin) {
		this.highValueMin = highValueMin;
	}

	public Double getHighValueMax() {
		return highValueMax;
	}

	public void setHighValueMax(Double highValueMax) {
		this.highValueMax = highValueMax;
	}

	public Integer getConditionOrd() {
		return conditionOrd;
	}

	public void setConditionOrd(Integer conditionOrd) {
		this.conditionOrd = conditionOrd;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
}

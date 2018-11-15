package com.bdxh.kmsale.bean.inventory;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CardPo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final Integer STATUS_SALE_OUT = Integer.valueOf(0);
	public static final Integer STATUS_UNVALID = Integer.valueOf(-1);
	public static final Integer STATUS_VALID = Integer.valueOf(1);
	public static final Integer CARD_TYPE_DEATH = Integer.valueOf(1);
	public static final Integer CARD_TYPE_ACTIVE = Integer.valueOf(2);
	public static final Integer CARD_TYPE_NET = Integer.valueOf(3);
	public static final Integer OPER_TYPE_IN = Integer.valueOf(0);
	public static final Integer OPER_TYPE_SHARE = Integer.valueOf(1);
	public static final Integer OPER_TYPE_SALE = Integer.valueOf(2);
	public static final Integer OPER_TYPE_RECOVER = Integer.valueOf(3);
	public static final Integer OPER_TYPE_DESTROY = Integer.valueOf(4);
	private BigDecimal id;
	private String snNo;
	private String simNumber;
	private Integer status;
	private String statusDesc;
	private Integer branchId;
	private Integer cardType;
	private String cardTypeDesc;
	private Integer operType;
	private Date operDate;
	private Date insertDate;
	private Double deposit;
	private String branchName;
	private String operTypeDesc;
	private String beginSimNumber;
	private String endSimNumber;

	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getSimNumber() {
		return this.simNumber;
	}

	public void setSimNumber(String simNumber) {
		this.simNumber = simNumber;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getBranchId() {
		return this.branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public Integer getCardType() {
		return this.cardType;
	}

	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}

	public Integer getOperType() {
		return this.operType;
	}

	public void setOperType(Integer operType) {
		this.operType = operType;
	}

	public Date getOperDate() {
		return this.operDate;
	}

	public void setOperDate(Date operDate) {
		this.operDate = operDate;
	}

	public Date getInsertDate() {
		return this.insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public Double getDeposit() {
		return this.deposit;
	}

	public void setDeposit(Double deposit) {
		this.deposit = deposit;
	}

	public void setCardTypeDesc(String cardTypeDesc) {
		this.cardTypeDesc = cardTypeDesc;
	}

	public String getCardTypeDesc() {
		return this.cardTypeDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public String getStatusDesc() {
		return this.statusDesc;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchName() {
		return this.branchName;
	}

	public void setOperTypeDesc(String operTypeDesc) {
		this.operTypeDesc = operTypeDesc;
	}

	public String getOperTypeDesc() {
		return this.operTypeDesc;
	}

	public void setSnNo(String snNo) {
		this.snNo = snNo;
	}

	public String getSnNo() {
		return this.snNo;
	}

	public String getBeginSimNumber() {
		return beginSimNumber;
	}

	public void setBeginSimNumber(String beginSimNumber) {
		this.beginSimNumber = beginSimNumber;
	}

	public String getEndSimNumber() {
		return endSimNumber;
	}

	public void setEndSimNumber(String endSimNumber) {
		this.endSimNumber = endSimNumber;
	}
}

package com.bdxh.kmsale.bean.inventory;

import java.io.Serializable;
import java.util.Date;

public class NumberPo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7594359254145862827L;
	/**
	 * 
	 */
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
	
	private String serchSvcNumber;//号码精准查询
	private String svcnumber2;//号码模糊查询
	private String beginSvcNumber;//起始号码
	private String endSvcNumber;//结束号码
	private Integer id;
	private String snNo;
	private String svcNumber;
	private String simNumber;
	private String numberLevel;
	private Integer status;
	private String statusDesc;
	private Integer branchId;
	private Integer isShare;
	private Integer cardType;
	private String cardTypeDesc;
	private Integer operType;
	private String operTypeDesc;
	private Date operDate;
	private Date insertDate;
	private String isShareDesc;
	private String branchName;
	private Integer orgId;

	public String getSerchSvcNumber() {
		return serchSvcNumber;
	}

	public void setSerchSvcNumber(String serchSvcNumber) {
		this.serchSvcNumber = serchSvcNumber;
	}

	public String getSvcnumber2() {
		return svcnumber2;
	}

	public void setSvcnumber2(String svcnumber2) {
		this.svcnumber2 = svcnumber2;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSvcNumber() {
		return this.svcNumber;
	}

	public void setSvcNumber(String svcNumber) {
		this.svcNumber = svcNumber;
	}

	public String getSimNumber() {
		return this.simNumber;
	}

	public void setSimNumber(String simNumber) {
		this.simNumber = simNumber;
	}

	public String getNumberLevel() {
		return this.numberLevel;
	}

	public void setNumberLevel(String numberLevel) {
		this.numberLevel = numberLevel;
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

	public Integer getIsShare() {
		return this.isShare;
	}

	public void setIsShare(Integer isShare) {
		this.isShare = isShare;
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

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public String getStatusDesc() {
		return this.statusDesc;
	}

	public void setCardTypeDesc(String cardTypeDesc) {
		this.cardTypeDesc = cardTypeDesc;
	}

	public String getCardTypeDesc() {
		return this.cardTypeDesc;
	}

	public void setOperTypeDesc(String operTypeDesc) {
		this.operTypeDesc = operTypeDesc;
	}

	public String getOperTypeDesc() {
		return this.operTypeDesc;
	}

	public String getIsShareDesc() {
		return this.isShareDesc;
	}

	public void setIsShareDesc(String isShareDesc) {
		this.isShareDesc = isShareDesc;
	}

	public String getBranchName() {
		return this.branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public void setSnNo(String snNo) {
		this.snNo = snNo;
	}

	public String getSnNo() {
		return this.snNo;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public String getEndSvcNumber() {
		return endSvcNumber;
	}

	public void setEndSvcNumber(String endSvcNumber) {
		this.endSvcNumber = endSvcNumber;
	}

	public String getBeginSvcNumber() {
		return beginSvcNumber;
	}

	public void setBeginSvcNumber(String beginSvcNumber) {
		this.beginSvcNumber = beginSvcNumber;
	}
}

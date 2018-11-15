package com.bdxh.kmsale.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class CardBo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 private BigDecimal id;
	  private String simNumber;
	  private Short status;
	  private String statusDesc;
	  private Integer branchId;
	  private Short cardType;
	  private String cardTypeDesc;
	  private Short operType;
	  private Date operDate;
	  private Date insertDate;
	  private Double deposit;
	  private String snNo;
	  private String operTypeDesc;
	  private Integer orgId;
	  private List<CardPo> pageData;
	  private List<CardPo> cardTypeList;
	  private List<CardPo> operTypeList;
	  private BigDecimal[] cardIds;
	  private CardPo card;
	  private String beginSimNumber;
	  private String endSimNumber;
	  private String likeSimNumber;
	  private List lvlTypeList;
	  private List statusList;
	  private String isAssign;
	  private String saveType;
	  private String branchName;
	  private String queryBranchId;
	  String operator;
	  private Result result;
	  
	  public void setId(BigDecimal id)
	  {
	    this.id = id;
	  }
	  
	  public BigDecimal getId()
	  {
	    return this.id;
	  }
	  
	  public void setSimNumber(String simNumber)
	  {
	    this.simNumber = simNumber;
	  }
	  
	  public String getSimNumber()
	  {
	    return this.simNumber;
	  }
	  
	  public void setStatus(Short status)
	  {
	    this.status = status;
	  }
	  
	  public Short getStatus()
	  {
	    return this.status;
	  }
	  
	  public void setStatusDesc(String statusDesc)
	  {
	    this.statusDesc = statusDesc;
	  }
	  
	  public String getStatusDesc()
	  {
	    return this.statusDesc;
	  }
	  
	  public void setBranchId(Integer branchId)
	  {
	    this.branchId = branchId;
	  }
	  
	  public Integer getBranchId()
	  {
	    return this.branchId;
	  }
	  
	  public void setCardType(Short cardType)
	  {
	    this.cardType = cardType;
	  }
	  
	  public Short getCardType()
	  {
	    return this.cardType;
	  }
	  
	  public void setCardTypeDesc(String cardTypeDesc)
	  {
	    this.cardTypeDesc = cardTypeDesc;
	  }
	  
	  public String getCardTypeDesc()
	  {
	    return this.cardTypeDesc;
	  }
	  
	  public void setOperType(Short operType)
	  {
	    this.operType = operType;
	  }
	  
	  public Short getOperType()
	  {
	    return this.operType;
	  }
	  
	  public void setOperDate(Date operDate)
	  {
	    this.operDate = operDate;
	  }
	  
	  public Date getOperDate()
	  {
	    return this.operDate;
	  }
	  
	  public void setInsertDate(Date insertDate)
	  {
	    this.insertDate = insertDate;
	  }
	  
	  public Date getInsertDate()
	  {
	    return this.insertDate;
	  }
	  
	  public void setDeposit(Double deposit)
	  {
	    this.deposit = deposit;
	  }
	  
	  public Double getDeposit()
	  {
	    return this.deposit;
	  }
	  
	  public void setPageData(List<CardPo> pageData)
	  {
	    this.pageData = pageData;
	  }
	  
	  public List<CardPo> getPageData()
	  {
	    return this.pageData;
	  }
	  
	  public void setCardTypeList(List<CardPo> cardTypeList)
	  {
	    this.cardTypeList = cardTypeList;
	  }
	  
	  public List<CardPo> getCardTypeList()
	  {
	    return this.cardTypeList;
	  }
	  
	  public void setCardIds(BigDecimal[] cardIds)
	  {
	    this.cardIds = cardIds;
	  }
	  
	  public BigDecimal[] getCardIds()
	  {
	    return this.cardIds;
	  }
	  
	  public void setCard(CardPo card)
	  {
	    this.card = card;
	  }
	  
	  public CardPo getCard()
	  {
	    return this.card;
	  }
	  
	  public void setOperTypeList(List<CardPo> operTypeList)
	  {
	    this.operTypeList = operTypeList;
	  }
	  
	  public List<CardPo> getOperTypeList()
	  {
	    return this.operTypeList;
	  }
	  
	  public void setOperator(String operator)
	  {
	    this.operator = operator;
	  }
	  
	  public String getOperator()
	  {
	    return this.operator;
	  }
	  
	  public void setResult(Result result)
	  {
	    this.result = result;
	  }
	  
	  public Result getResult()
	  {
	    return this.result;
	  }
	  
	  public void setOrgId(Integer orgId)
	  {
	    this.orgId = orgId;
	  }
	  
	  public Integer getOrgId()
	  {
	    return this.orgId;
	  }
	  
	  public void setBeginSimNumber(String beginSimNumber)
	  {
	    this.beginSimNumber = beginSimNumber;
	  }
	  
	  public String getBeginSimNumber()
	  {
	    return this.beginSimNumber;
	  }
	  
	  public void setEndSimNumber(String endSimNumber)
	  {
	    this.endSimNumber = endSimNumber;
	  }
	  
	  public String getEndSimNumber()
	  {
	    return this.endSimNumber;
	  }
	  
	  public void setLikeSimNumber(String likeSimNumber)
	  {
	    this.likeSimNumber = likeSimNumber;
	  }
	  
	  public String getLikeSimNumber()
	  {
	    return this.likeSimNumber;
	  }
	  
	  public void setLvlTypeList(List lvlTypeList)
	  {
	    this.lvlTypeList = lvlTypeList;
	  }
	  
	  public List getLvlTypeList()
	  {
	    return this.lvlTypeList;
	  }
	  
	  public void setStatusList(List statusList)
	  {
	    this.statusList = statusList;
	  }
	  
	  public List getStatusList()
	  {
	    return this.statusList;
	  }
	  
	  public void setIsAssign(String isAssign)
	  {
	    this.isAssign = isAssign;
	  }
	  
	  public String getIsAssign()
	  {
	    return this.isAssign;
	  }
	  
	  public void setSaveType(String saveType)
	  {
	    this.saveType = saveType;
	  }
	  
	  public String getSaveType()
	  {
	    return this.saveType;
	  }
	  
	  public void setBranchName(String branchName)
	  {
	    this.branchName = branchName;
	  }
	  
	  public String getBranchName()
	  {
	    return this.branchName;
	  }
	  
	  public void setOperTypeDesc(String operTypeDesc)
	  {
	    this.operTypeDesc = operTypeDesc;
	  }
	  
	  public String getOperTypeDesc()
	  {
	    return this.operTypeDesc;
	  }
	  
	  public String getQueryBranchId()
	  {
	    return this.queryBranchId;
	  }
	  
	  public void setQueryBranchId(String queryBranchId)
	  {
	    this.queryBranchId = queryBranchId;
	  }
	  
	  public void setSnNo(String snNo)
	  {
	    this.snNo = snNo;
	  }
	  
	  public String getSnNo()
	  {
	    return this.snNo;
	  }

}

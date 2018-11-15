package com.bdxh.kmsale.bean.oper;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author 莫夏欣
 * @date 创建时间：2018年11月13日,下午7:58:27
 * @Description  投诉记录
 */
public class Complain implements Serializable{
	private static final long serialVersionUID = -8324026086310089432L;
	private Integer complainId;//投诉编号
	private Date complainDate;//投诉时间
	private String svcNumber;//手机号
	private String complainName;//用户姓名
	private Date saleDate;//办卡时间
	private String productId;//套餐
	private String deviceId;//终端
	private String memo;//投诉内容
	private Integer status;//投诉紧迫性
	private String operatorName;//接线客服姓名
	private String operatorId;//接线客服id
	private Integer operatorStatus;//接线客服处理状态
	private Integer operatorRecord;//接线客服处理记录
	private String noId;//代理人编码
	private String agentName;//代理人姓名
	private Integer agentStatus;//代理人处理状态
	private Integer agentRecord;//代理人处理记录
	private Date agentDate;//代理人处理时间
	private String branchName;//代理人所属分区
	private String branchId;//分区编码
	private String branchManagerName;//分区经理姓名
	private String branchManagerId;//分区经理编码
	private Integer branchStatus;//分区经理处理状态
	private Integer branchRecord;//分区经理处理记录
	private Date branchDate;//分区经理处理时间
	private String operOrgId;//代理人所属分部
	private String operOrgName;//代理人所属分部
	private String operOrgManagerName;//分部经理姓名
	private String operOrgManagerId;//分部经理编码
	private Integer operOrgStatus;//分部经理处理状态
	private Integer operOrgRecord;//分部经理处理记录
	private Date operOrgDate;//分部经理处理时间
	private Integer endStatus;//最终处理状态
	private Integer endRecord;//最终处理记录
	private Integer isOver;//是否处理完结
	private Date overData;//完结时间
	private String operId;//登记人
	private Date operData;//登记时间
	private Integer branchCity;//所属城市
	private String saleDateStart;
	private String saleDateEnd;
	public Integer getComplainId() {
		return complainId;
	}
	public void setComplainId(Integer complainId) {
		this.complainId = complainId;
	}
	public Date getComplainDate() {
		return complainDate;
	}
	public void setComplainDate(Date complainDate) {
		this.complainDate = complainDate;
	}
	public String getSvcNumber() {
		return svcNumber;
	}
	public void setSvcNumber(String svcNumber) {
		this.svcNumber = svcNumber;
	}
	public String getComplainName() {
		return complainName;
	}
	public void setComplainName(String complainName) {
		this.complainName = complainName;
	}
	public Date getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public String getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	public Integer getOperatorStatus() {
		return operatorStatus;
	}
	public void setOperatorStatus(Integer operatorStatus) {
		this.operatorStatus = operatorStatus;
	}
	public Integer getOperatorRecord() {
		return operatorRecord;
	}
	public void setOperatorRecord(Integer operatorRecord) {
		this.operatorRecord = operatorRecord;
	}
	public String getNoId() {
		return noId;
	}
	public void setNoId(String noId) {
		this.noId = noId;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public Integer getAgentStatus() {
		return agentStatus;
	}
	public void setAgentStatus(Integer agentStatus) {
		this.agentStatus = agentStatus;
	}
	public Integer getAgentRecord() {
		return agentRecord;
	}
	public void setAgentRecord(Integer agentRecord) {
		this.agentRecord = agentRecord;
	}
	public Date getAgentDate() {
		return agentDate;
	}
	public void setAgentDate(Date agentDate) {
		this.agentDate = agentDate;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBranchManagerName() {
		return branchManagerName;
	}
	public void setBranchManagerName(String branchManagerName) {
		this.branchManagerName = branchManagerName;
	}
	public String getBranchManagerId() {
		return branchManagerId;
	}
	public void setBranchManagerId(String branchManagerId) {
		this.branchManagerId = branchManagerId;
	}
	public Integer getBranchStatus() {
		return branchStatus;
	}
	public void setBranchStatus(Integer branchStatus) {
		this.branchStatus = branchStatus;
	}
	public Integer getBranchRecord() {
		return branchRecord;
	}
	public void setBranchRecord(Integer branchRecord) {
		this.branchRecord = branchRecord;
	}
	public Date getBranchDate() {
		return branchDate;
	}
	public void setBranchDate(Date branchDate) {
		this.branchDate = branchDate;
	}
	public String getOperOrgName() {
		return operOrgName;
	}
	public void setOperOrgName(String operOrgName) {
		this.operOrgName = operOrgName;
	}
	public String getOperOrgManagerName() {
		return operOrgManagerName;
	}
	public void setOperOrgManagerName(String operOrgManagerName) {
		this.operOrgManagerName = operOrgManagerName;
	}
	public String getOperOrgManagerId() {
		return operOrgManagerId;
	}
	public void setOperOrgManagerId(String operOrgManagerId) {
		this.operOrgManagerId = operOrgManagerId;
	}
	public Integer getOperOrgStatus() {
		return operOrgStatus;
	}
	public void setOperOrgStatus(Integer operOrgStatus) {
		this.operOrgStatus = operOrgStatus;
	}
	public Integer getOperOrgRecord() {
		return operOrgRecord;
	}
	public void setOperOrgRecord(Integer operOrgRecord) {
		this.operOrgRecord = operOrgRecord;
	}
	public Date getOperOrgDate() {
		return operOrgDate;
	}
	public void setOperOrgDate(Date operOrgDate) {
		this.operOrgDate = operOrgDate;
	}
	public Integer getEndStatus() {
		return endStatus;
	}
	public void setEndStatus(Integer endStatus) {
		this.endStatus = endStatus;
	}
	public Integer getEndRecord() {
		return endRecord;
	}
	public void setEndRecord(Integer endRecord) {
		this.endRecord = endRecord;
	}
	public Integer getIsOver() {
		return isOver;
	}
	public void setIsOver(Integer isOver) {
		this.isOver = isOver;
	}
	public Date getOverData() {
		return overData;
	}
	public void setOverData(Date overData) {
		this.overData = overData;
	}
	public String getOperId() {
		return operId;
	}
	public void setOperId(String operId) {
		this.operId = operId;
	}
	public Date getOperData() {
		return operData;
	}
	public void setOperData(Date operData) {
		this.operData = operData;
	}
	
	public Integer getBranchCity() {
		return branchCity;
	}
	public void setBranchCity(Integer branchCity) {
		this.branchCity = branchCity;
	}
	
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public String getOperOrgId() {
		return operOrgId;
	}
	public void setOperOrgId(String operOrgId) {
		this.operOrgId = operOrgId;
	}
	public String getSaleDateStart() {
		return saleDateStart;
	}
	public void setSaleDateStart(String saleDateStart) {
		this.saleDateStart = saleDateStart;
	}
	public String getSaleDateEnd() {
		return saleDateEnd;
	}
	public void setSaleDateEnd(String saleDateEnd) {
		this.saleDateEnd = saleDateEnd;
	}
	@Override
	public String toString() {
		return "Complain [complainId=" + complainId + ", complainDate=" + complainDate + ", svcNumber=" + svcNumber
				+ ", complainName=" + complainName + ", saleDate=" + saleDate + ", productId=" + productId
				+ ", deviceId=" + deviceId + ", memo=" + memo + ", status=" + status + ", operatorName=" + operatorName
				+ ", operatorId=" + operatorId + ", operatorStatus=" + operatorStatus + ", operatorRecord="
				+ operatorRecord + ", noId=" + noId + ", agentName=" + agentName + ", agentStatus=" + agentStatus
				+ ", agentRecord=" + agentRecord + ", agentDate=" + agentDate + ", branchName=" + branchName
				+ ", branchId=" + branchId + ", branchManagerName=" + branchManagerName + ", branchManagerId="
				+ branchManagerId + ", branchStatus=" + branchStatus + ", branchRecord=" + branchRecord
				+ ", branchDate=" + branchDate + ", operOrgId=" + operOrgId + ", operOrgName=" + operOrgName
				+ ", operOrgManagerName=" + operOrgManagerName + ", operOrgManagerId=" + operOrgManagerId
				+ ", operOrgStatus=" + operOrgStatus + ", operOrgRecord=" + operOrgRecord + ", operOrgDate="
				+ operOrgDate + ", endStatus=" + endStatus + ", endRecord=" + endRecord + ", isOver=" + isOver
				+ ", overData=" + overData + ", operId=" + operId + ", operData=" + operData + ", branchCity="
				+ branchCity + ", saleDateStart=" + saleDateStart + ", saleDateEnd=" + saleDateEnd + "]";
	}

}

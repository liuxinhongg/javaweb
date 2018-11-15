package com.bdxh.kmsale.bean.org;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class BranchPo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9034909826212926635L;
	
	public static final String BRANCH_TYPE_HEAD_BRANCH = "01";
	public static final String BRANCH_TYPE_SUB_BRANCH = "02";
	public static final String BRANCH_TYPE_DIVIDE = "03";
	private Integer id;
	private String branchName;
	private Integer upId;
	private String upName;
	private String branchTypeCode;
	private String branchTypeDesc;
	private Date createDate;
	private Integer lvl;
	private Integer status;
	private String statusDesc;
	private String effectMonth;
	private String agentName;
	private String noId;
	private String operId;
	private Integer rootId;
	private String areaName;
	private Integer branchCity;
	private String effectMonthView;
	
	private List<BranchPo> childList;

	public BranchPo() {
		
	}

	public BranchPo(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBranchName() {
		return this.branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public Integer getUpId() {
		return this.upId;
	}

	public void setUpId(Integer upId) {
		this.upId = upId;
	}

	public String getBranchTypeCode() {
		return this.branchTypeCode;
	}

	public void setBranchTypeCode(String branchTypeCode) {
		this.branchTypeCode = branchTypeCode;
	}

	public String getBranchTypeDesc() {
		return this.branchTypeDesc;
	}

	public void setBranchTypeDesc(String branchTypeDesc) {
		this.branchTypeDesc = branchTypeDesc;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getLvl() {
		return this.lvl;
	}

	public void setLvl(Integer lvl) {
		this.lvl = lvl;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public String getStatusDesc() {
		return this.statusDesc;
	}

	public void setEffectMonth(String effectMonth) {
		this.effectMonth = effectMonth;
	}

	public String getEffectMonth() {
		return this.effectMonth;
	}

	public void setUpName(String upName) {
		this.upName = upName;
	}

	public String getUpName() {
		return this.upName;
	}

	public String getAgentName() {
		return this.agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getNoId() {
		return this.noId;
	}

	public void setNoId(String noId) {
		this.noId = noId;
	}

	public String getOperId() {
		return this.operId;
	}

	public void setOperId(String operId) {
		this.operId = operId;
	}

	public List<BranchPo> getChildList() {
		return childList;
	}

	public void setChildList(List<BranchPo> childList) {
		this.childList = childList;
	}

	public Integer getRootId() {
		return rootId;
	}

	public void setRootId(Integer rootId) {
		this.rootId = rootId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Integer getBranchCity() {
		return branchCity;
	}

	public void setBranchCity(Integer branchCity) {
		this.branchCity = branchCity;
	}

	public String getEffectMonthView() {
		
		if(StringUtils.isNoneBlank(this.effectMonth)){
			
			effectMonthView = this.effectMonth.substring(0, 4) + "-" + this.effectMonth.substring(4, 6);
		}
		
		return effectMonthView;
	}

	public void setEffectMonthView(String effectMonthView) {
		this.effectMonthView = effectMonthView;
	}
}

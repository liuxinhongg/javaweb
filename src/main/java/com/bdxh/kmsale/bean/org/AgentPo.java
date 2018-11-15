package com.bdxh.kmsale.bean.org;

import java.io.Serializable;
import java.util.Date;

public class AgentPo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3937125384436600914L;
	
	private Date createDate;
	private String operId;
	private String noId;
	private String pNoId;
	private Integer lvl;
	private String branchId;
	private Integer status;
	private Date statusDate;
	private String idNumber;
	private String agentName;
	private String origo;
	private String nation;
	private String domicile;
	private Date birthday;
	private String address;
	private String sex;
	private String tel;
	private String healthy;
	private String education;
	private String graduateSchool;
	private Date graduateDate;
	private String politic;
	private String bank;
	private String bankNo;
	private String family;
	private String experience;
	private String hobby;
	private String photo;
	private String idPic;
	private Double balance;
	private String remark;
	private String stautsDesc;
	private String branchName;
	private String upAgentName;
	private String orgId;
	private String upBranchName;
	private String upBranchId;
	private String modifyMan;
	private Date modifyTime;
	private String noTel;
	private String pageType;
	private String startTime;
	private String endTime;
	private Integer joinType;
	private Integer branchCity;
	private String createDateStr;
	private Integer totalZeroMonth;

	public String getStatusDesc() {
		return this.stautsDesc;
	}

	public void setStautsDesc(String stautsDesc) {
		this.noId = stautsDesc;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getNoId() {
		return this.noId;
	}

	public void setNoId(String noId) {
		this.noId = noId;
	}

	public String getPNoId() {
		return this.pNoId;
	}

	public void setPNoId(String pNoId) {
		this.pNoId = pNoId;
	}

	public Integer getLvl() {
		return this.lvl;
	}

	public void setLvl(Integer lvl) {
		this.lvl = lvl;
	}

	public String getBranchId() {
		return this.branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getStatusDate() {
		return this.statusDate;
	}

	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}

	public String getIdNumber() {
		return this.idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getAgentName() {
		return this.agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getOrigo() {
		return this.origo;
	}

	public void setOrigo(String origo) {
		this.origo = origo;
	}

	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getDomicile() {
		return this.domicile;
	}

	public void setDomicile(String domicile) {
		this.domicile = domicile;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getHealthy() {
		return this.healthy;
	}

	public void setHealthy(String healthy) {
		this.healthy = healthy;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getGraduateSchool() {
		return this.graduateSchool;
	}

	public void setGraduateSchool(String graduateSchool) {
		this.graduateSchool = graduateSchool;
	}

	public Date getGraduateDate() {
		return this.graduateDate;
	}

	public void setGraduateDate(Date graduateDate) {
		this.graduateDate = graduateDate;
	}

	public String getPolitic() {
		return this.politic;
	}

	public void setPolitic(String politic) {
		this.politic = politic;
	}

	public String getBank() {
		return this.bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBankNo() {
		return this.bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}

	public String getFamily() {
		return this.family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getExperience() {
		return this.experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getHobby() {
		return this.hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getIdPic() {
		return this.idPic;
	}

	public void setIdPic(String idPic) {
		this.idPic = idPic;
	}

	public Double getBalance() {
		return this.balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getpNoId() {
		return this.pNoId;
	}

	public void setpNoId(String pNoId) {
		this.pNoId = pNoId;
	}

	public String getBranchName() {
		return this.branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getStautsDesc() {
		return this.stautsDesc;
	}

	public String getUpAgentName() {
		return this.upAgentName;
	}

	public void setUpAgentName(String upAgentName) {
		this.upAgentName = upAgentName;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgId() {
		return this.orgId;
	}

	public void setUpBranchName(String upBranchName) {
		this.upBranchName = upBranchName;
	}

	public String getUpBranchName() {
		return this.upBranchName;
	}

	public void setUpBranchId(String upBranchId) {
		this.upBranchId = upBranchId;
	}

	public String getUpBranchId() {
		return this.upBranchId;
	}

	public void setOperId(String operId) {
		this.operId = operId;
	}

	public String getOperId() {
		return this.operId;
	}

	public String getModifyMan() {
		return this.modifyMan;
	}

	public Date getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyMan(String modifyMan) {
		this.modifyMan = modifyMan;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getNoTel() {
		return this.noTel;
	}

	public void setNoTel(String noTel) {
		this.noTel = noTel;
	}

	public String getPageType() {
		return this.pageType;
	}

	public void setPageType(String pageType) {
		this.pageType = pageType;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getJoinType() {
		return joinType;
	}

	public void setJoinType(Integer joinType) {
		this.joinType = joinType;
	}

	public Integer getBranchCity() {
		return branchCity;
	}

	public void setBranchCity(Integer branchCity) {
		this.branchCity = branchCity;
	}

	public String getCreateDateStr() {
		return createDateStr;
	}

	public void setCreateDateStr(String createDateStr) {
		this.createDateStr = createDateStr;
	}

	public Integer getTotalZeroMonth() {
		return totalZeroMonth;
	}

	public void setTotalZeroMonth(Integer totalZeroMonth) {
		this.totalZeroMonth = totalZeroMonth;
	}
}

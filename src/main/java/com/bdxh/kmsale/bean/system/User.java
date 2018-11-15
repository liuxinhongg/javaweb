package com.bdxh.kmsale.bean.system;

import java.util.Date;
/**
 * 
 * @author 莫夏欣
 * @date 创建时间：2018年10月23日,上午10:36:50
 * @Description 用户
 */
public class User implements java.io.Serializable{
	private static final long serialVersionUID = -6426320040035399574L;
	private String loginId;
	private String staffId;
	private String areaId;
	private String cityId;
	private String townId;
	private String sectId;
	private String department;
	private String loginName;
	private String password;
	private String gender;
	private String mobilePhone;
	private String email;
	private String officeTel;
	private String state;
	private String initPwd;
	private Date regDate;
	private String themes; 
	private String memo;
	private String updateUser;
	private Date updateDate;
	private String areaDesc;
	private String cityDesc;
	private String townDesc;
	private String sectDesc;
	private String deptName;
	private String branchName;
	private String isAdmin;
	private String currLoginId;
	private String roleName;
	private String manageLevel;
	private String markArea;
	private String sellArea;
	private String serviceArea;
	private String marktainFlag;
	private String deptParentNo;//上级部门编码
	private Date activeTime;//最后登录时间
	private String verifyCode; //验证码
	private String userIsneedVerifyCode;
	private String isFirstLoad;
	private Date isModPwdFirstTime;
	private String isPerChanngePwd; 
	public String getSellArea() {
		return sellArea;
	}
	public void setSellArea(String sellArea) {
		this.sellArea = sellArea;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getTownId() {
		return townId;
	}
	public void setTownId(String townId) {
		this.townId = townId;
	}
	public String getSectId() {
		return sectId;
	}
	public void setSectId(String sectId) {
		this.sectId = sectId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOfficeTel() {
		return officeTel;
	}
	public void setOfficeTel(String officeTel) {
		this.officeTel = officeTel;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getInitPwd() {
		return initPwd;
	}
	public void setInitPwd(String initPwd) {
		this.initPwd = initPwd;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getThemes() {
		return themes;
	}
	public void setThemes(String themes) {
		this.themes = themes;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getAreaDesc() {
		return areaDesc;
	}
	public void setAreaDesc(String areaDesc) {
		this.areaDesc = areaDesc;
	}
	public String getCityDesc() {
		return cityDesc;
	}
	public void setCityDesc(String cityDesc) {
		this.cityDesc = cityDesc;
	}
	public String getTownDesc() {
		return townDesc;
	}
	public void setTownDesc(String townDesc) {
		this.townDesc = townDesc;
	}
	public String getSectDesc() {
		return sectDesc;
	}
	public void setSectDesc(String sectDesc) {
		this.sectDesc = sectDesc;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getCurrLoginId() {
		return currLoginId;
	}
	public void setCurrLoginId(String currLoginId) {
		this.currLoginId = currLoginId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getManageLevel() {
		return manageLevel;
	}
	public void setManageLevel(String manageLevel) {
		this.manageLevel = manageLevel;
	}
	public String getMarkArea() {
		return markArea;
	}
	public void setMarkArea(String markArea) {
		this.markArea = markArea;
	}
	public String getServiceArea() {
		return serviceArea;
	}
	public void setServiceArea(String serviceArea) {
		this.serviceArea = serviceArea;
	}
	public String getMarktainFlag() {
		return marktainFlag;
	}
	public void setMarktainFlag(String marktainFlag) {
		this.marktainFlag = marktainFlag;
	}
	public String getDeptParentNo() {
		return deptParentNo;
	}
	public void setDeptParentNo(String deptParentNo) {
		this.deptParentNo = deptParentNo;
	}
	public Date getActiveTime() {
		return activeTime;
	}
	public void setActiveTime(Date activeTime) {
		this.activeTime = activeTime;
	}
	public String getVerifyCode() {
		return verifyCode;
	}
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	public String getUserIsneedVerifyCode() {
		return userIsneedVerifyCode;
	}
	public void setUserIsneedVerifyCode(String userIsneedVerifyCode) {
		this.userIsneedVerifyCode = userIsneedVerifyCode;
	}
	public String getIsFirstLoad() {
		return isFirstLoad;
	}
	public void setIsFirstLoad(String isFirstLoad) {
		this.isFirstLoad = isFirstLoad;
	}
	public Date getIsModPwdFirstTime() {
		return isModPwdFirstTime;
	}
	public void setIsModPwdFirstTime(Date isModPwdFirstTime) {
		this.isModPwdFirstTime = isModPwdFirstTime;
	}
	public String getIsPerChanngePwd() {
		return isPerChanngePwd;
	}
	public void setIsPerChanngePwd(String isPerChanngePwd) {
		this.isPerChanngePwd = isPerChanngePwd;
	}
	@Override
	public String toString() {
		return "User [loginId=" + loginId + ", staffId=" + staffId + ", areaId=" + areaId + ", cityId=" + cityId
				+ ", townId=" + townId + ", sectId=" + sectId + ", department=" + department + ", loginName="
				+ loginName + ", password=" + password + ", gender=" + gender + ", mobilePhone=" + mobilePhone
				+ ", email=" + email + ", officeTel=" + officeTel + ", state=" + state + ", initPwd=" + initPwd
				+ ", regDate=" + regDate + ", themes=" + themes + ", memo=" + memo + ", updateUser=" + updateUser
				+ ", updateDate=" + updateDate + ", areaDesc=" + areaDesc + ", cityDesc=" + cityDesc + ", townDesc="
				+ townDesc + ", sectDesc=" + sectDesc + ", deptName=" + deptName + ", branchName=" + branchName
				+ ", isAdmin=" + isAdmin + ", currLoginId=" + currLoginId + ", roleName=" + roleName + ", manageLevel="
				+ manageLevel + ", markArea=" + markArea + ", sellArea=" + sellArea + ", serviceArea=" + serviceArea
				+ ", marktainFlag=" + marktainFlag + ", deptParentNo=" + deptParentNo + ", activeTime=" + activeTime
				+ ", verifyCode=" + verifyCode + ", userIsneedVerifyCode=" + userIsneedVerifyCode + ", isFirstLoad="
				+ isFirstLoad + ", isModPwdFirstTime=" + isModPwdFirstTime + ", isPerChanngePwd=" + isPerChanngePwd
				+ "]";
	}

}

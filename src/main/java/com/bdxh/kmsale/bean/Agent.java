package com.bdxh.kmsale.bean;

import java.io.Serializable;
import java.util.Date;
/**
 * @author  作者:Binzh
 * @version 创建时间:2018-10-23 22:21:09
 *          类说明:业务代理人信息po类
 */
public class Agent implements Serializable{

	private static final long serialVersionUID = 110413316558163293L;
	
	//业务编号
	private String noId; 
	//推荐人业务编号
	private String pNoId;
	//血缘树层级
	private Integer lvl;
	//部门，业务代理人得部门类型都是分区
	private String branchId;
	//状态  0注销  1正常  2除名(黑名单)
	private Integer status; 
	//状态变更时间
	private Date statusDate;
	//创建时间
	private Date createDate;
	//身份证号码
	private String idNumber;
	//姓名
	private String agentName; 
	//籍贯 
	private String origo;  
	//民族
	private String nation;
	//户籍地址
	private String domicile;
	//出生日期
	private Date birthDay;
	//联系地址
	private String address;
	//性别
	private String sex;
	//业务电话
	private String tel;
	//健康状态
	private String healthy;
	//教育程度
	private String education;
	//毕业院校
	private String graduateSchool;
	//毕业时间
	private Date graduateDate;
	//政治面貌
	private String politic;
	//开户银行
	private String bank;
	//银行帐号
	private String bankNo;
	//家庭情况
	private String family;
	//工作经历
	private String experience;
	//业余爱好
	private String hobby;
	//照片所在的文件路径
	private String photo;
	//证件复印件所在的文件路径
	private String idPic;
	//押金余额
	private int balance;
	//备注
	private String remark;
	//修改人
	private String modifyMan;
	//修改时间
	private Date modifyTime;
	//业务代理卡号码(可为空，补助话费号码)
	private String noTel;
	public String getNoId() {
		return noId;
	}
	public void setNoId(String noId) {
		this.noId = noId;
	}
	public String getpNoId() {
		return pNoId;
	}
	public void setpNoId(String pNoId) {
		this.pNoId = pNoId;
	}
	public Integer getLvl() {
		return lvl;
	}
	public void setLvl(Integer lvl) {
		this.lvl = lvl;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getStatusDate() {
		return statusDate;
	}
	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public String getOrigo() {
		return origo;
	}
	public void setOrigo(String origo) {
		this.origo = origo;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getDomicile() {
		return domicile;
	}
	public void setDomicile(String domicile) {
		this.domicile = domicile;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getHealthy() {
		return healthy;
	}
	public void setHealthy(String healthy) {
		this.healthy = healthy;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getGraduateSchool() {
		return graduateSchool;
	}
	public void setGraduateSchool(String graduateSchool) {
		this.graduateSchool = graduateSchool;
	}
	public Date getGraduateDate() {
		return graduateDate;
	}
	public void setGraduateDate(Date graduateDate) {
		this.graduateDate = graduateDate;
	}
	public String getPolitic() {
		return politic;
	}
	public void setPolitic(String politic) {
		this.politic = politic;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getBankNo() {
		return bankNo;
	}
	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getIdPic() {
		return idPic;
	}
	public void setIdPic(String idPic) {
		this.idPic = idPic;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getModifyMan() {
		return modifyMan;
	}
	public void setModifyMan(String modifyMan) {
		this.modifyMan = modifyMan;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	public String getNoTel() {
		return noTel;
	}
	public void setNoTel(String noTel) {
		this.noTel = noTel;
	}
	
	
}

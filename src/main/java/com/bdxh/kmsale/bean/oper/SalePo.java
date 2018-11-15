package com.bdxh.kmsale.bean.oper;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @author 莫夏欣
 * @date 创建时间：2018年11月7日,下午2:31:04
 * @Description 销售记录po
 */
public class SalePo implements Serializable{
	private static final long serialVersionUID = 1322434956767418929L;
	public static final Short STATUS_DEL = Short.valueOf((short)0);
	  public static final Short SALE_MODE_WEB = Short.valueOf((short)1);
	  public static final Short SALE_MODE_WAP = Short.valueOf((short)2);
	  public static final Short SALE_MODE_SMS = Short.valueOf((short)3);
	  private String branchName;//部门
	  private Integer saleId;
	  private Integer status;//状态
	  private String statusDesc;//状态
	  private Integer saleMode;
	  private String saleModeDesc;
	  private String noId;//业务编码
	  private Integer numberId;
	  private Integer cardId;
	  private String svcNumber;//手机号
	  private String sim;
	  private String userNo;
	  private Double price;//销售面值
	  private Double price2;//活动金额
	  private Double price3;//对账金额
	  private Double devicePrice;
	  private Date saleDate; //开卡日期 销售日期
	  private Integer productId;//套餐id
	  private Integer deviceId;//设备信息
	  private Integer isActive;
	  private Integer four;
	  private Integer noneFour;
	  private Integer active;
	  private Double deduct;//终端提成
	  private String operId;
	  private String orgId;
	  private String productName;//套餐名
	  private String deviceName;//终端
	  private String agentName;//代理人姓名
	  private String operName;//操作人
	  private String imei;//串号
	  private Double rateCnt;//折算量
	  private String simStr;//卡号
	  private String operOrgName;//操作人所属部门
	  private String svcType;
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public Integer getSaleId() {
		return saleId;
	}
	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getStatusDesc() {
		return statusDesc;
	}
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
	public Integer getSaleMode() {
		return saleMode;
	}
	public void setSaleMode(Integer saleMode) {
		this.saleMode = saleMode;
	}
	public String getSaleModeDesc() {
		return saleModeDesc;
	}
	public void setSaleModeDesc(String saleModeDesc) {
		this.saleModeDesc = saleModeDesc;
	}
	public String getNoId() {
		return noId;
	}
	public void setNoId(String noId) {
		this.noId = noId;
	}
	public Integer getNumberId() {
		return numberId;
	}
	public void setNumberId(Integer numberId) {
		this.numberId = numberId;
	}
	public Integer getCardId() {
		return cardId;
	}
	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}
	public String getSvcNumber() {
		return svcNumber;
	}
	public void setSvcNumber(String svcNumber) {
		this.svcNumber = svcNumber;
	}
	public String getSim() {
		return sim;
	}
	public void setSim(String sim) {
		this.sim = sim;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getPrice2() {
		return price2;
	}
	public void setPrice2(Double price2) {
		this.price2 = price2;
	}
	public Double getPrice3() {
		return price3;
	}
	public void setPrice3(Double price3) {
		this.price3 = price3;
	}
	public Double getDevicePrice() {
		return devicePrice;
	}
	public void setDevicePrice(Double devicePrice) {
		this.devicePrice = devicePrice;
	}
	public Date getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	public Integer getFour() {
		return four;
	}
	public void setFour(Integer four) {
		this.four = four;
	}
	public Integer getNoneFour() {
		return noneFour;
	}
	public void setNoneFour(Integer noneFour) {
		this.noneFour = noneFour;
	}
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
	public Double getDeduct() {
		return deduct;
	}
	public void setDeduct(Double deduct) {
		this.deduct = deduct;
	}
	public String getOperId() {
		return operId;
	}
	public void setOperId(String operId) {
		this.operId = operId;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public String getOperName() {
		return operName;
	}
	public void setOperName(String operName) {
		this.operName = operName;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public Double getRateCnt() {
		return rateCnt;
	}
	public void setRateCnt(Double rateCnt) {
		this.rateCnt = rateCnt;
	}
	public String getSimStr() {
		return simStr;
	}
	public void setSimStr(String simStr) {
		this.simStr = simStr;
	}
	public String getOperOrgName() {
		return operOrgName;
	}
	public void setOperOrgName(String operOrgName) {
		this.operOrgName = operOrgName;
	}
	public String getSvcType() {
		return svcType;
	}
	public void setSvcType(String svcType) {
		this.svcType = svcType;
	}
	@Override
	public String toString() {
		return "SalePo [branchName=" + branchName + ", saleId=" + saleId + ", status=" + status + ", statusDesc="
				+ statusDesc + ", saleMode=" + saleMode + ", saleModeDesc=" + saleModeDesc + ", noId=" + noId
				+ ", numberId=" + numberId + ", cardId=" + cardId + ", svcNumber=" + svcNumber + ", sim=" + sim
				+ ", userNo=" + userNo + ", price=" + price + ", price2=" + price2 + ", price3=" + price3
				+ ", devicePrice=" + devicePrice + ", saleDate=" + saleDate + ", productId=" + productId + ", deviceId="
				+ deviceId + ", isActive=" + isActive + ", four=" + four + ", noneFour=" + noneFour + ", active="
				+ active + ", deduct=" + deduct + ", operId=" + operId + ", orgId=" + orgId + ", productName="
				+ productName + ", deviceName=" + deviceName + ", agentName=" + agentName + ", operName=" + operName
				+ ", imei=" + imei + ", rateCnt=" + rateCnt + ", simStr=" + simStr + ", operOrgName=" + operOrgName
				+ ", svcType=" + svcType + "]";
	}
	  
}

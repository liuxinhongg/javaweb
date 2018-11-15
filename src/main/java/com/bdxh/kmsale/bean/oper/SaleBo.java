package com.bdxh.kmsale.bean.oper;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import com.bdxh.kmsale.bean.Result;

/**
 * 
 * @author 莫夏欣
 * @date 创建时间：2018年11月7日,下午2:58:27
 * @Description  销售记录bo
 */
public class SaleBo implements Serializable{
	private Integer saleId;
	private Integer status;
	private String statusDesc;
	private Integer saleMode;
	private String saleModeDesc;
	private String noId;
	private Integer numberId;
	private Integer cardId;
	private String svcNumber;
	private String sim;
	private String userNo;
	private Double price;
	private Double price2;
	private Double price3;
	private Double devicePrice;
	private String saleDate;
	private Integer productId;
	private Integer deviceId;
	private Integer isActive;
	private Integer four;
	private Integer noneFour;
	private Integer active;
	private Double deduct;
	private String operId;
	private String operName;
	private String agentName;
	private String productDesc;
	private String productType;
	private Integer orgId;
	private String indexNumber;
	private String indexCard;
	private List<SalePo> saleModeList;
	private SalePo sale;
	private SalePo saleSum;
	private Integer[] saleIds;
	private Double rateCnt;
	private String simStr;
	private List productList;
	private List productTypeList;
	private String saleDateStart;
	private String saleDateEnd;
	private String branchName;
	private String fileName;
	private String operator;
	private String saveType;
	private Result result;
	private List<String> content;
	private String isCanViewAllData;
	private String loginId;
	private String svcType;
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
	public String getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(String saleDate) {
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
	public String getOperName() {
		return operName;
	}
	public void setOperName(String operName) {
		this.operName = operName;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public String getIndexNumber() {
		return indexNumber;
	}
	public void setIndexNumber(String indexNumber) {
		this.indexNumber = indexNumber;
	}
	public String getIndexCard() {
		return indexCard;
	}
	public void setIndexCard(String indexCard) {
		this.indexCard = indexCard;
	}
	public List<SalePo> getSaleModeList() {
		return saleModeList;
	}
	public void setSaleModeList(List<SalePo> saleModeList) {
		this.saleModeList = saleModeList;
	}
	public SalePo getSale() {
		return sale;
	}
	public void setSale(SalePo sale) {
		this.sale = sale;
	}
	public SalePo getSaleSum() {
		return saleSum;
	}
	public void setSaleSum(SalePo saleSum) {
		this.saleSum = saleSum;
	}
	public Integer[] getSaleIds() {
		return saleIds;
	}
	public void setSaleIds(Integer[] saleIds) {
		this.saleIds = saleIds;
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
	public List getProductList() {
		return productList;
	}
	public void setProductList(List productList) {
		this.productList = productList;
	}
	public List getProductTypeList() {
		return productTypeList;
	}
	public void setProductTypeList(List productTypeList) {
		this.productTypeList = productTypeList;
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
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getSaveType() {
		return saveType;
	}
	public void setSaveType(String saveType) {
		this.saveType = saveType;
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public List<String> getContent() {
		return content;
	}
	public void setContent(List<String> content) {
		this.content = content;
	}
	public String getIsCanViewAllData() {
		return isCanViewAllData;
	}
	public void setIsCanViewAllData(String isCanViewAllData) {
		this.isCanViewAllData = isCanViewAllData;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getSvcType() {
		return svcType;
	}
	public void setSvcType(String svcType) {
		this.svcType = svcType;
	}
	@Override
	public String toString() {
		return "SaleBo [saleId=" + saleId + ", status=" + status + ", statusDesc=" + statusDesc + ", saleMode="
				+ saleMode + ", saleModeDesc=" + saleModeDesc + ", noId=" + noId + ", numberId=" + numberId
				+ ", cardId=" + cardId + ", svcNumber=" + svcNumber + ", sim=" + sim + ", userNo=" + userNo + ", price="
				+ price + ", price2=" + price2 + ", price3=" + price3 + ", devicePrice=" + devicePrice + ", saleDate="
				+ saleDate + ", productId=" + productId + ", deviceId=" + deviceId + ", isActive=" + isActive
				+ ", four=" + four + ", noneFour=" + noneFour + ", active=" + active + ", deduct=" + deduct
				+ ", operId=" + operId + ", operName=" + operName + ", agentName=" + agentName + ", productDesc="
				+ productDesc + ", productType=" + productType + ", orgId=" + orgId + ", indexNumber=" + indexNumber
				+ ", indexCard=" + indexCard + ", saleModeList=" + saleModeList + ", sale=" + sale + ", saleSum="
				+ saleSum + ", saleIds=" + Arrays.toString(saleIds) + ", rateCnt=" + rateCnt + ", simStr=" + simStr
				+ ", productList=" + productList + ", productTypeList=" + productTypeList + ", saleDateStart="
				+ saleDateStart + ", saleDateEnd=" + saleDateEnd + ", branchName=" + branchName + ", fileName="
				+ fileName + ", operator=" + operator + ", saveType=" + saveType + ", result=" + result + ", content="
				+ content + ", isCanViewAllData=" + isCanViewAllData + ", loginId=" + loginId + ", svcType=" + svcType
				+ "]";
	}
	
}

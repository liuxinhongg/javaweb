package com.bdxh.kmsale.bean.code;

import java.util.Arrays;
import java.util.List;

import com.bdxh.kmsale.bean.Result;
/**
 * 
 * @author 莫夏欣
 * @date 创建时间：2018年11月7日,下午6:13:14
 * @Description 套餐Bo
 */
public class ProductBo {
	  private String productId;
	  private String productName;
	  private String productDesc;
	  private String productType;
	  private Short four;
	  private Short noneFour;
	  private Short action;
	  private Short isView;
	  private String productTypeDesc;
	  private List<ProductPo> pageData;
	  private List<ProductPo> productTypeList;
	  private String[] productIds;
	  private ProductPo product;
	  private String operator;
	  private Result result;
	  private String isIh;
	  private String isKh;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
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
	public Short getFour() {
		return four;
	}
	public void setFour(Short four) {
		this.four = four;
	}
	public Short getNoneFour() {
		return noneFour;
	}
	public void setNoneFour(Short noneFour) {
		this.noneFour = noneFour;
	}
	public Short getAction() {
		return action;
	}
	public void setAction(Short action) {
		this.action = action;
	}
	public Short getIsView() {
		return isView;
	}
	public void setIsView(Short isView) {
		this.isView = isView;
	}
	public String getProductTypeDesc() {
		return productTypeDesc;
	}
	public void setProductTypeDesc(String productTypeDesc) {
		this.productTypeDesc = productTypeDesc;
	}
	public List<ProductPo> getPageData() {
		return pageData;
	}
	public void setPageData(List<ProductPo> pageData) {
		this.pageData = pageData;
	}
	public List<ProductPo> getProductTypeList() {
		return productTypeList;
	}
	public void setProductTypeList(List<ProductPo> productTypeList) {
		this.productTypeList = productTypeList;
	}
	public String[] getProductIds() {
		return productIds;
	}
	public void setProductIds(String[] productIds) {
		this.productIds = productIds;
	}
	public ProductPo getProduct() {
		return product;
	}
	public void setProduct(ProductPo product) {
		this.product = product;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public String getIsIh() {
		return isIh;
	}
	public void setIsIh(String isIh) {
		this.isIh = isIh;
	}
	public String getIsKh() {
		return isKh;
	}
	public void setIsKh(String isKh) {
		this.isKh = isKh;
	}
	@Override
	public String toString() {
		return "ProductBo [productId=" + productId + ", productName=" + productName + ", productDesc=" + productDesc
				+ ", productType=" + productType + ", four=" + four + ", noneFour=" + noneFour + ", action=" + action
				+ ", isView=" + isView + ", productTypeDesc=" + productTypeDesc + ", pageData=" + pageData
				+ ", productTypeList=" + productTypeList + ", productIds=" + Arrays.toString(productIds) + ", product="
				+ product + ", operator=" + operator + ", result=" + result + ", isIh=" + isIh + ", isKh=" + isKh + "]";
	}
	  
}

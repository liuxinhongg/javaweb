package com.bdxh.kmsale.bean.code;

import java.io.Serializable;
/**
 * 
 * @author 莫夏欣
 * @date 创建时间：2018年11月7日,下午6:13:14
 * @Description 套餐Po
 */
public class ProductPo implements Serializable{
	private static final long serialVersionUID = 799868542158700418L;
	public static final int PRODUCT_TYPE_OTHER = -1;
	  public static final int PRODUCT_TYPE_NETCARD = 1;
	  public static final int PRODUCT_TYPE_2G = 2;
	  public static final int PRODUCT_TYPE_3G = 3;
	  private String productId;
	  private String productName;
	  private String productDesc;
	  private String productType;
	  private Double four;
	  private Double noneFour;
	  private Double action;
	  private Short isView;
	  private String productTypeDesc;
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
	public Double getFour() {
		return four;
	}
	public void setFour(Double four) {
		this.four = four;
	}
	public Double getNoneFour() {
		return noneFour;
	}
	public void setNoneFour(Double noneFour) {
		this.noneFour = noneFour;
	}
	public Double getAction() {
		return action;
	}
	public void setAction(Double action) {
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
		return "ProductPo [productId=" + productId + ", productName=" + productName + ", productDesc=" + productDesc
				+ ", productType=" + productType + ", four=" + four + ", noneFour=" + noneFour + ", action=" + action
				+ ", isView=" + isView + ", productTypeDesc=" + productTypeDesc + ", isIh=" + isIh + ", isKh=" + isKh
				+ "]";
	}
	  
}

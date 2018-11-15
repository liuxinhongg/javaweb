package com.bdxh.kmsale.bean.code;

import java.io.Serializable;
/**
 * 
 * @author 莫夏欣
 * @date 创建时间：2018年11月7日,下午3:29:06
 * @Description 终端po
 */
public class DevicePo implements Serializable{
	private static final long serialVersionUID = 1252934740041534228L;
	public static final int DEVICE_TYPE_OTHER = -1;
	  public static final int DEVICE_TYPE_MOBILE = 1;
	  public static final int DEVICE_TYPE_NETCARD = 2;
	  private Integer deviceId;
	  private String deviceName;
	  private String deviceDesc;
	  private Double deduct;
	  private String deviceTypeCode;
	  private String deviceTypeDesc;
	  private Double price;
	  private String status;
	  private String schemeTypeDesc;
	  private String schemeTypeCode;
	public Integer getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getDeviceDesc() {
		return deviceDesc;
	}
	public void setDeviceDesc(String deviceDesc) {
		this.deviceDesc = deviceDesc;
	}
	public Double getDeduct() {
		return deduct;
	}
	public void setDeduct(Double deduct) {
		this.deduct = deduct;
	}
	public String getDeviceTypeCode() {
		return deviceTypeCode;
	}
	public void setDeviceTypeCode(String deviceTypeCode) {
		this.deviceTypeCode = deviceTypeCode;
	}
	public String getDeviceTypeDesc() {
		return deviceTypeDesc;
	}
	public void setDeviceTypeDesc(String deviceTypeDesc) {
		this.deviceTypeDesc = deviceTypeDesc;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSchemeTypeDesc() {
		return schemeTypeDesc;
	}
	public void setSchemeTypeDesc(String schemeTypeDesc) {
		this.schemeTypeDesc = schemeTypeDesc;
	}
	public String getSchemeTypeCode() {
		return schemeTypeCode;
	}
	public void setSchemeTypeCode(String schemeTypeCode) {
		this.schemeTypeCode = schemeTypeCode;
	}
	@Override
	public String toString() {
		return "DevicePo [deviceId=" + deviceId + ", deviceName=" + deviceName + ", deviceDesc=" + deviceDesc
				+ ", deduct=" + deduct + ", deviceTypeCode=" + deviceTypeCode + ", deviceTypeDesc=" + deviceTypeDesc
				+ ", price=" + price + ", status=" + status + ", schemeTypeDesc=" + schemeTypeDesc + ", schemeTypeCode="
				+ schemeTypeCode + "]";
	}
	  
}

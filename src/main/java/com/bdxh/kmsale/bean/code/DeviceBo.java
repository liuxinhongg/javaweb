package com.bdxh.kmsale.bean.code;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import com.bdxh.kmsale.bean.Result;
/**
 * 
 * @author 莫夏欣
 * @date 创建时间：2018年11月7日,下午3:29:11
 * @Description 终端bo
 */
public class DeviceBo implements Serializable{
	private static final long serialVersionUID = -5425110628865300385L;
	private Integer deviceId;
	  private String deviceName;
	  private String deviceRemark;
	  private String deviceTypeCode;
	  private String deviceStatus;
	  private DevicePo device;
	  private List deviceTypeList;
	  private String operator;
	  private Result result;
	  private List<DevicePo> pageData;
	  private Integer[] deviceIds;
	  private String schemeTypeCode;
	  private List schemeTypeList;
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
	public String getDeviceRemark() {
		return deviceRemark;
	}
	public void setDeviceRemark(String deviceRemark) {
		this.deviceRemark = deviceRemark;
	}
	public String getDeviceTypeCode() {
		return deviceTypeCode;
	}
	public void setDeviceTypeCode(String deviceTypeCode) {
		this.deviceTypeCode = deviceTypeCode;
	}
	public String getDeviceStatus() {
		return deviceStatus;
	}
	public void setDeviceStatus(String deviceStatus) {
		this.deviceStatus = deviceStatus;
	}
	public DevicePo getDevice() {
		return device;
	}
	public void setDevice(DevicePo device) {
		this.device = device;
	}
	public List getDeviceTypeList() {
		return deviceTypeList;
	}
	public void setDeviceTypeList(List deviceTypeList) {
		this.deviceTypeList = deviceTypeList;
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
	public List<DevicePo> getPageData() {
		return pageData;
	}
	public void setPageData(List<DevicePo> pageData) {
		this.pageData = pageData;
	}
	public Integer[] getDeviceIds() {
		return deviceIds;
	}
	public void setDeviceIds(Integer[] deviceIds) {
		this.deviceIds = deviceIds;
	}
	public String getSchemeTypeCode() {
		return schemeTypeCode;
	}
	public void setSchemeTypeCode(String schemeTypeCode) {
		this.schemeTypeCode = schemeTypeCode;
	}
	public List getSchemeTypeList() {
		return schemeTypeList;
	}
	public void setSchemeTypeList(List schemeTypeList) {
		this.schemeTypeList = schemeTypeList;
	}
	@Override
	public String toString() {
		return "DeviceBo [deviceId=" + deviceId + ", deviceName=" + deviceName + ", deviceRemark=" + deviceRemark
				+ ", deviceTypeCode=" + deviceTypeCode + ", deviceStatus=" + deviceStatus + ", device=" + device
				+ ", deviceTypeList=" + deviceTypeList + ", operator=" + operator + ", result=" + result + ", pageData="
				+ pageData + ", deviceIds=" + Arrays.toString(deviceIds) + ", schemeTypeCode=" + schemeTypeCode
				+ ", schemeTypeList=" + schemeTypeList + "]";
	}
	  
}

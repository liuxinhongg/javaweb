package com.bdxh.kmsale.bean.system;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @author 莫夏欣
 * @date 创建时间：2018年10月26日,上午10:35:34
 * @Description 部门管理
 */
public class Department implements Serializable{
	private static final long serialVersionUID = -6918144259134755070L;
	private String deptId;
	private String state;
	private String leaf;
	private Date stateDate;
	private String parentId;
	private String deptName;
	private String address;
	private String ord;
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getLeaf() {
		return leaf;
	}
	public void setLeaf(String leaf) {
		this.leaf = leaf;
	}
	public Date getStateDate() {
		return stateDate;
	}
	public void setStateDate(Date stateDate) {
		this.stateDate = stateDate;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOrd() {
		return ord;
	}
	public void setOrd(String ord) {
		this.ord = ord;
	}
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", state=" + state + ", leaf=" + leaf + ", stateDate=" + stateDate
				+ ", parentId=" + parentId + ", deptName=" + deptName + ", address=" + address + ", ord=" + ord + "]";
	}
	
	
}

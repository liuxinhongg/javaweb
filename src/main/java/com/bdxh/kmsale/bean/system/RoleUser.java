package com.bdxh.kmsale.bean.system;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author 莫夏欣
 * @date 创建时间：2018年11月7日,上午10:36:30
 * @Description 用户和角色对应关系
 */
public class RoleUser implements Serializable{

	private static final long serialVersionUID = 4977651684508178737L;
	private String roleId;
	private String loginId;
	private String userId;
	private Date updateDate;
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	@Override
	public String toString() {
		return "RoleUser [roleId=" + roleId + ", loginId=" + loginId + ", userId=" + userId + ", updateDate="
				+ updateDate + "]";
	}
	
}

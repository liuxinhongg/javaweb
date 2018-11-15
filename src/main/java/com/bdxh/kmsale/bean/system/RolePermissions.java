package com.bdxh.kmsale.bean.system;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @author 莫夏欣
 * @date 创建时间：2018年20月25日,上午10:36:15
 * @Description 角色授权
 */
public class RolePermissions implements Serializable{

	private static final long serialVersionUID = -5086228059499215538L;
	private String roleId;
	private String moduleId;
	private String operationId;
	private String authRead;
	private String authCreate;
	private String authUpdate;
	private String authDelete;
	private String updateUser;
	private Date updateDate;
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public String getOperationId() {
		return operationId;
	}
	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}
	public String getAuthRead() {
		return authRead;
	}
	public void setAuthRead(String authRead) {
		this.authRead = authRead;
	}
	public String getAuthCreate() {
		return authCreate;
	}
	public void setAuthCreate(String authCreate) {
		this.authCreate = authCreate;
	}
	public String getAuthUpdate() {
		return authUpdate;
	}
	public void setAuthUpdate(String authUpdate) {
		this.authUpdate = authUpdate;
	}
	public String getAuthDelete() {
		return authDelete;
	}
	public void setAuthDelete(String authDelete) {
		this.authDelete = authDelete;
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
	@Override
	public String toString() {
		return "RolePermissions [roleId=" + roleId + ", moduleId=" + moduleId + ", operationId=" + operationId
				+ ", authRead=" + authRead + ", authCreate=" + authCreate + ", authUpdate=" + authUpdate
				+ ", authDelete=" + authDelete + ", updateUser=" + updateUser + ", updateDate=" + updateDate + "]";
	}

}


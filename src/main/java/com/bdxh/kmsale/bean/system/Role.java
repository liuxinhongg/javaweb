package com.bdxh.kmsale.bean.system;
import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @author 莫夏欣
 * @date 创建时间：2018年10月25日,上午10:36:06
 * @Description 角色
 */
public class Role implements Serializable{
	private static final long serialVersionUID = 530089505689372653L;
	private String id;
	private String roleId;
	private String roleName;
	private String memo;
	private String parentId;
	private String updateUser;
	private Date updateDate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
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
		return "Role [id=" + id + ", roleId=" + roleId + ", roleName=" + roleName + ", memo=" + memo + ", parentId="
				+ parentId + ", updateUser=" + updateUser + ", updateDate=" + updateDate + "]";
	}

}

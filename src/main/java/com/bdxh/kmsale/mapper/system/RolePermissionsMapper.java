package com.bdxh.kmsale.mapper.system;

import java.util.List;

import com.bdxh.kmsale.bean.system.RolePermissions;
/**
 * 角色权限管理
 * @author 莫夏欣
 *2018.10.25
 */
public interface RolePermissionsMapper {
	void deletePermissionsByRoleId(String roleId);
	void deletePermissionsBymoduleId(String moduleId);
	void insertPermissions(RolePermissions rolePermissions);
	List<RolePermissions> selecPermissionsByRoleId(String roleId);
	List<RolePermissions> selecPermissionsByModuleId(String moduleId);
	RolePermissions selecPermissions(RolePermissions rolePermissions);
	void updatePermissions(RolePermissions rolePermissions);
}

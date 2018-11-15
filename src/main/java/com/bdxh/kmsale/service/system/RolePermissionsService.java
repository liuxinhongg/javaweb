package com.bdxh.kmsale.service.system;

import java.util.List;

import com.bdxh.kmsale.bean.system.RolePermissions;
/**
 * 菜单管理
 * @author BDXH-222
 *
 */
public interface RolePermissionsService {
	void deletePermissionsByRoleId(String roleId);
	void deletePermissionsBymoduleId(String moduleId);
	void insertPermissions(RolePermissions rolePermissions);
	List<RolePermissions> selecPermissionsByRoleId(String roleId);
	List<RolePermissions> selecPermissionsByModuleId(String moduleId);
	RolePermissions selecPermissions(RolePermissions rolePermissions);
	void updatePermissions(RolePermissions rolePermissions);
}

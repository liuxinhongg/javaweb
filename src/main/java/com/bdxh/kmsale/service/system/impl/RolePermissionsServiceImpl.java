package com.bdxh.kmsale.service.system.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bdxh.kmsale.bean.system.RolePermissions;
import com.bdxh.kmsale.mapper.system.RolePermissionsMapper;
import com.bdxh.kmsale.service.system.RolePermissionsService;
/**
 * 权限管理
 * @author 莫夏欣
 *
 */
@Service
public class RolePermissionsServiceImpl implements RolePermissionsService{
	@Resource
	private RolePermissionsMapper rpm;
	@Override
	public void deletePermissionsByRoleId(String roleId) {
		rpm.deletePermissionsByRoleId(roleId);
	}

	@Override
	public void deletePermissionsBymoduleId(String modeuletId) {
		rpm.deletePermissionsBymoduleId(modeuletId);
	}

	@Override
	public void insertPermissions(RolePermissions rolePermissions) {
		rpm.insertPermissions(rolePermissions);
	}

	@Override
	public RolePermissions selecPermissions(RolePermissions rolePermissions) {
		return rpm.selecPermissions(rolePermissions);
	}

	@Override
	public void updatePermissions(RolePermissions rolePermissions) {
		rpm.updatePermissions(rolePermissions);
	}

	@Override
	public List<RolePermissions> selecPermissionsByRoleId(String roleId) {
		return rpm.selecPermissionsByRoleId(roleId);
	}

	@Override
	public List<RolePermissions> selecPermissionsByModuleId(String moduleId) {
		return rpm.selecPermissionsByRoleId(moduleId);
	}

}

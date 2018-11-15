package com.bdxh.kmsale.mapper.system;

import java.util.List;

import com.bdxh.kmsale.bean.system.Role;
import com.bdxh.kmsale.bean.system.RoleUser;
/**
 * 角色对应用户管理
 * @author 莫夏欣
 *
 */
public interface RoleUserMapper {
	List<Role> listRoleOfUser(String loginId);
	List<Role> listUserOfRole(String roleId);
	void deleteRoleByloginId(String loginId);
	void deleteRoleByroleId(String roleId);
	void insertUserRole(RoleUser roleUser);
}

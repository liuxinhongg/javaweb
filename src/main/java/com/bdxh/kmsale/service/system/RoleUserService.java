package com.bdxh.kmsale.service.system;

import java.util.List;

import com.bdxh.kmsale.bean.system.Role;
import com.bdxh.kmsale.bean.system.RoleUser;
/**
 * 用户角色对应关系
 * @author 莫夏欣
 *
 */
public interface RoleUserService {
	List<Role> listRoleOfUser(String loginId);
	List<Role> listUserOfRole(String roleId);
	void deleteRoleByloginId(String loginId);
	void deleteRoleByroleId(String roleId);
	void insertUserRole(RoleUser roleUser);
}

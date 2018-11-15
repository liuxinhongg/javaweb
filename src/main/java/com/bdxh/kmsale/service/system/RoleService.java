package com.bdxh.kmsale.service.system;

import java.util.List;

import com.bdxh.kmsale.bean.ConditionResource;
import com.bdxh.kmsale.bean.system.Role;
/**
 * 角色管理
 * @author 莫夏欣2018.10.25
 *
 */
public interface RoleService {
	List<Role> selectListRole(ConditionResource conditionResource);
	Integer selectRoleCountCondition(ConditionResource conditionResource);
	Integer selectRoleCountAll();
	Role selectRoleById(String roleId);
	void insertRole(Role role);
	void updateRole(Role role);
	void deleteRole(String roleId);
	List<Role> selectRoleByAll();
}

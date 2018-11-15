package com.bdxh.kmsale.mapper.system;

import java.util.List;

import com.bdxh.kmsale.bean.ConditionResource;
import com.bdxh.kmsale.bean.system.Role;
/**
 * 角色Mapper
 * @author 莫夏欣
 *
 */
public interface RoleMapper {
	List<Role> selectListRole(ConditionResource conditionResource);
	Integer selectRoleCountCondition(ConditionResource conditionResource);
	Integer selectRoleCountAll();
	Role selectRoleById(String roleId);
	void insertRole(Role role);
	void updateRole(Role role);
	void deleteRole(String roleId);
	List<Role> selectRoleByAll();
}

package com.bdxh.kmsale.service.system.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bdxh.kmsale.bean.ConditionResource;
import com.bdxh.kmsale.bean.system.Role;
import com.bdxh.kmsale.mapper.system.RoleMapper;
import com.bdxh.kmsale.service.ex.ObjectNotFoundException;
import com.bdxh.kmsale.service.system.RoleService;
/**
 * 角色管理
 * @author 莫夏欣2018.10.25
 *
 */
@Service
public class RoleServiceImpl implements RoleService{
	@Resource
	private RoleMapper roleMapper;

	@Override
	public List<Role> selectListRole(ConditionResource conditionResource) {
		return roleMapper.selectListRole(conditionResource);
	}

	@Override
	public Integer selectRoleCountCondition(ConditionResource conditionResource) {
		return roleMapper.selectRoleCountCondition(conditionResource);
	}

	@Override
	public Integer selectRoleCountAll() {
		return roleMapper.selectRoleCountAll();
	}

	@Override
	public Role selectRoleById(String roleId) {
		return roleMapper.selectRoleById(roleId);
	}

	@Override
	public void insertRole(Role role) {
		if(roleMapper.selectRoleById(role.getRoleId())!=null) {
			throw new ObjectNotFoundException("角色ID已经存在!");
		}else {			
			roleMapper.insertRole(role);
		}
	}

	@Override
	public void updateRole(Role role) {
			roleMapper.updateRole(role);
		}

	@Override
	public void deleteRole(String roleId) {
		roleMapper.deleteRole(roleId);
	}
	
	@Override
	public List<Role> selectRoleByAll() {
		return roleMapper.selectRoleByAll();
	}
}

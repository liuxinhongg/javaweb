package com.bdxh.kmsale.service.system.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bdxh.kmsale.bean.system.Role;
import com.bdxh.kmsale.bean.system.RoleUser;
import com.bdxh.kmsale.mapper.system.RoleUserMapper;
import com.bdxh.kmsale.service.system.RoleUserService;

@Service
public class RoleUserServiceImpl implements RoleUserService{
	@Resource
	private RoleUserMapper roleUserMapper;
	@Override
	public List<Role> listRoleOfUser(String loginId) {
		return roleUserMapper.listRoleOfUser(loginId);
	}

	@Override
	public List<Role> listUserOfRole(String roleId) {
		return roleUserMapper.listUserOfRole(roleId);
	}

	@Override
	public void deleteRoleByloginId(String loginId) {
		roleUserMapper.deleteRoleByloginId(loginId);
	}

	@Override
	public void deleteRoleByroleId(String roleId) {
		roleUserMapper.deleteRoleByroleId(roleId);
	}

	@Override
	public void insertUserRole(RoleUser roleUser) {
		roleUserMapper.insertUserRole(roleUser);
	}

}

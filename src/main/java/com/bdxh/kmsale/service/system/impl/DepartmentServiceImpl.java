package com.bdxh.kmsale.service.system.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bdxh.kmsale.bean.system.Department;
import com.bdxh.kmsale.mapper.system.DepartmentMapper;
/**
 * 部门管理
 * @author 莫夏欣
 *
 */
@Service
public class DepartmentServiceImpl implements com.bdxh.kmsale.service.system.DepartmentService{
	@Resource
	private DepartmentMapper departmentMapper;
	@Override
	public List<Department> selectDepartmentList(Department department) {
		return departmentMapper.selectDepartmentList(department);
	}

	@Override
	public void insertDepartment(Department department) {
		departmentMapper.insertDepartment(department);
	}

	@Override
	public void updateDepartment(Department department) {
		departmentMapper.updateDepartment(department);
	}

	@Override
	public void deleteDepartment(String deptId) {
		departmentMapper.deleteDepartment(deptId);
	}

}

package com.bdxh.kmsale.mapper.system;

import java.util.List;

import com.bdxh.kmsale.bean.system.Department;

/**
 * 部门管理
 * @author 莫夏欣
 *
 */
public interface DepartmentMapper {
	List<Department> selectDepartmentList(Department department);
	void insertDepartment(Department department);
	void updateDepartment(Department department);
	void deleteDepartment(String deptId);
}

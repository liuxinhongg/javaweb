package com.bdxh.kmsale.service.system;

import java.util.List;

import com.bdxh.kmsale.bean.system.Department;
/**
 * 部门管理
 * @author 部门管理
 *
 */
public interface DepartmentService {
	List<Department> selectDepartmentList(Department department);
	void insertDepartment(Department department);
	void updateDepartment(Department department);
	void deleteDepartment(String deptId);
}

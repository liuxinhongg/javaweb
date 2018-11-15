package com.bdxh.kmsale.mapper.system;

import java.util.List;

import com.bdxh.kmsale.bean.ConditionResource;
import com.bdxh.kmsale.bean.system.User;

public interface UserMapper {
	//查询所有人
	List<User> selectUserAll();
	//查询用户数量
	Integer selectCountAll();
	//根据ID查找用户
	User selectUserById(String loginId);
	//根据邮箱查询数量
	Integer selectCountUserByEmail(String email);
	//根据手机号查询数量
	Integer selectCountUserByPhone(String mobilePhone);
	//根据工号ID查询数量
	Integer selectCountUserByStaffId(String staffId);
	//添加用户
	void insertUser(User user);
	//修改用户信息
	void updateUser(User user);
	//根据ID删除用户
	void deleteById(String loginId);
	//条件分页查询
	List<User> seleclByResource(ConditionResource conditionResource);
	//条件查询条数
	Integer selectCountByResource(ConditionResource conditionResource);
	//根据ID注销用户
	void logOffUser(String loginId); 
	//根据ID激活用户
	void activateUser(String loginId); 

}
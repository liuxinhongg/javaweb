package com.bdxh.kmsale.service.system;

import java.util.List;

import com.bdxh.kmsale.bean.ConditionResource;
import com.bdxh.kmsale.bean.system.User;
/**
 * 用户管理
 * @author 莫夏欣2018.10.25
 *
 */
public interface UserService{
	//登录
	User login(String username,String password);
	//改密码
	void changePassword(String loginId, String oldPwd, String newPwd);
	//修改个人信息
	void updateUser(User user);
	User selectUserById(String loginId);
	Integer selectCountAll();
	//根据ID删除
	void logOffUser(String loginId);
	//添加用户
	void insertUser(User user);
	//条件分页查询用户列表
	List<User> selectByResource(ConditionResource conditionResource);
	//条件查询总数(不分页)
	Integer seleclCountByResource(ConditionResource conditionResource);
}

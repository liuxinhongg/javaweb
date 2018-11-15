package com.bdxh.kmsale.service.system.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bdxh.kmsale.mapper.system.UserMapper;
import com.bdxh.kmsale.bean.ConditionResource;
import com.bdxh.kmsale.bean.system.User;
import com.bdxh.kmsale.service.ex.PassWordNotFoundException;
import com.bdxh.kmsale.service.ex.UserNameNotFoundException;
import com.bdxh.kmsale.service.system.UserService;
/**
 * 用户管理service
 * @author 莫夏欣2018.10.25
 *
 */
@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserMapper userMapper;
	/* ----- 登录 ------  */
	public User login(String loginId, String password) {
		User user=userMapper.selectUserById(loginId);
		System.out.println(user);
		if(user!=null){
			if(user.getPassword().equals(password)){
				//登录成功
				return user;
			}else{
				throw new 
				PassWordNotFoundException(
						"密码错误");
			}
		}else{
			throw new 
			PassWordNotFoundException(
					"用户名不存在");
		}
	}

	@Override
	public void changePassword(String loginId, String oldPwd, String newPwd) {
		//查询用户
		User user=userMapper.selectUserById(loginId);
		if(user==null){
			//如果用户修改时候，账号被管理员删了
			throw new
			PassWordNotFoundException("用户不存在");
		}else{
			if(user.getPassword().equals(oldPwd)){
				//如果密码匹配
				user.setPassword(newPwd);
				user.setCurrLoginId(loginId);
				user.setUpdateDate(new Date());
				userMapper.updateUser(user);
			}else{
				throw new
				PassWordNotFoundException("密码不正确");
			}
		}	
	}

	@Override
	public void updateUser(User user) {
		//根据id查询;返回user对象
		User user2 = userMapper.selectUserById(user.getLoginId());
		if(userMapper.selectCountUserByStaffId(user.getStaffId())>0
				&&!user.getStaffId().equals(user2.getStaffId())){
			throw new UserNameNotFoundException("工号已存在");
		}else if(userMapper.selectCountUserByPhone(user.getMobilePhone())>0
				&&!user.getMobilePhone().equals(user2.getMobilePhone())){
			throw new UserNameNotFoundException("手机号已存在");
		}else{
			//修改用户信息
			userMapper.updateUser(user);
		}
	}

	@Override
	public void logOffUser(String loginId) {
		User user = userMapper.selectUserById(loginId);
		if(user.getState().equals("0")){
			//如果user==null;抛出异常
			throw new UserNameNotFoundException("已注销，请勿重复操作");
		}else{
			//删除用户信息
			userMapper.logOffUser(loginId);
		}
	}

	@Override
	public List<User> selectByResource(ConditionResource conditionResource) {
		return userMapper.seleclByResource(conditionResource);	
	}

	@Override
	public Integer seleclCountByResource(ConditionResource conditionResource) {
		return userMapper.selectCountByResource(conditionResource);
	}

	@Override
	public void insertUser(User user) {
		System.out.println(user);
		User user2 = userMapper.selectUserById(user.getLoginId());
		if(user2!=null){
			throw new UserNameNotFoundException("用户ID已存在");
		}else if(userMapper.selectCountUserByStaffId(user.getStaffId())>0){
			throw new UserNameNotFoundException("工号已存在");
		}else if(userMapper.selectCountUserByPhone(user.getMobilePhone())>0){
			throw new UserNameNotFoundException("手机号已存在");
		}else{
			//可以添加用户
			userMapper.insertUser(user);
		}
	}

	@Override
	public Integer selectCountAll() {
		return userMapper.selectCountAll();
	}

	@Override
	public User selectUserById(String loginId) {
		return userMapper.selectUserById(loginId);
	}

}

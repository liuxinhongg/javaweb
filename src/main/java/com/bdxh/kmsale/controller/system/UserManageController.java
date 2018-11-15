package com.bdxh.kmsale.controller.system;

import java.sql.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bdxh.kmsale.bean.AbstractEntity;
import com.bdxh.kmsale.common.Constants;
import com.bdxh.kmsale.bean.ConditionResource;
import com.bdxh.kmsale.bean.system.Role;
import com.bdxh.kmsale.bean.system.RoleUser;
import com.bdxh.kmsale.bean.system.User;
import com.bdxh.kmsale.controller.AbstractBackendController;
import com.bdxh.kmsale.service.ex.PassWordNotFoundException;
import com.bdxh.kmsale.service.system.DepartmentService;
import com.bdxh.kmsale.service.system.RoleUserService;
import com.bdxh.kmsale.service.system.UserService;
import com.bdxh.kmsale.utils.Encrypt;
/**
 * 用户管理Controller
 * @author 莫夏欣 2018.10.25
 *
 */
@Controller
@RequestMapping("/manage/user")
public class UserManageController extends AbstractBackendController<AbstractEntity, Long>{
	@Resource
	private UserService userService;
	@Resource
	private DepartmentService deparService;
	@Resource
	private RoleUserService roleuserService;
	//显示用户列表
	@RequestMapping("/list")
	public String showList() {
		return "system/listUser";
	}
	
	//显示login页面
	@RequestMapping("/showAdd")
	public String showAddLogin(){
		return "system/addUser";
	}
	
	//显示修改用户界面
	@RequestMapping("/showUpdate")
	public String showUpdate() {
		return "system/editUser";
	}
	
	//输出用户列表(分页)
	@RequestMapping(value = "/toList",method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> toList(
			@RequestBody ConditionResource conditionResource) {
		Integer pageCurrent=conditionResource.getPageCurrent();//当前页
		if(pageCurrent==null||pageCurrent==0||pageCurrent.equals("")) {
			pageCurrent=1;
		}
		conditionResource.setPageCurrent(pageCurrent);
		if(conditionResource.getName()=="") {
			conditionResource.setName(null);
		}
		if(conditionResource.getId()=="") {
			conditionResource.setId(null);
		}
		//条件查询返回数
		Integer userCountCondition=userService.seleclCountByResource(conditionResource);
		//一共多少用户
		Integer userCountAll=userService.selectCountAll();
		//每页显示的数据
		Integer pageSize=conditionResource.getPageSize();
		//总页数
		Integer pageCount = (userCountCondition + pageSize - 1) / pageSize;
		if(conditionResource.getPageCurrent()>pageCount){
			conditionResource.setPageCurrent(pageCount);
			pageCurrent=pageCount;
		}
		List<User> users=userService.selectByResource(conditionResource);
		System.out.println(users);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("users", users);
		map.put("userCountAll", userCountAll);
		map.put("pageSize", pageSize);
		map.put("pageCount", pageCount);
		map.put("userCountCondition", userCountCondition);
		map.put("pageCurrent", pageCurrent);
		return getJsonResponseEntity(map);  
	}

	//添加用户
	@RequestMapping(value="/addUser",method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> addUser(
			HttpServletRequest request,HttpServletResponse response,
			HttpSession session){
		Map<String, Object> map=new HashMap<String, Object>();
		try {
			User user=new User();
			
			user.setLoginId(request.getParameter("loginId"));
			user.setStaffId(request.getParameter("staffId"));
			user.setLoginName(request.getParameter("loginName"));
			user.setGender(request.getParameter("gender"));
			user.setDepartment(request.getParameter("department"));
			user.setState(request.getParameter("state"));
			user.setIsAdmin(request.getParameter("isAdmin"));
			user.setEmail(request.getParameter("email"));
			user.setMobilePhone(request.getParameter("mobilePhone"));
			user.setMemo(request.getParameter("memo"));
			Encrypt encrypt = new Encrypt();
			String password=encrypt.encode(request.getParameter("password"));
			user.setPassword(password);
			userService.insertUser(user);
			System.out.println(user);
			//以下是添加角色列表
			String roles=request.getParameter("roles");
			if(roles!=""&&roles!=null) {
				String[] role= roles.split(",");
				User currUser=(User) session.getAttribute(Constants.SESSION_USER);
				RoleUser roleUser=new RoleUser();
				roleUser.setUserId(currUser.getLoginId());
				roleUser.setLoginId(user.getLoginId());
				for(int i=0;i<role.length;i++){
					roleUser.setRoleId(role[i]);
					roleuserService.insertUserRole(roleUser);
				}
			}
			//添加角色完
			map.put("state", 0);
			map.put("msg", "添加成功");
		} catch (Exception e) {
			map.put("state", -1);
			map.put("msg", e.getMessage());
		}
		System.out.println("输出map"+map.toString());
		return getJsonResponseEntity(map); 
	}
	
	//显示用户数据
	@RequestMapping(value="/showUser",method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> showUser(
			@RequestParam(value="loginId",required=false) String loginId){
		Map<String, Object> map=new HashMap<String, Object>();
		User user=userService.selectUserById(loginId);
		//不输出密码
		List<Role> roles=roleuserService.listRoleOfUser(loginId);
		map.put("user", user);
		map.put("roles", roles);
		return getJsonResponseEntity(map); 
	}
	
	//执行修改用户
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> update(
			HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session){
		Map<String, Object> map=new HashMap<String, Object>();
		try {
			User user=new User();
			String loginId=request.getParameter("loginId");
			user.setLoginId(loginId);
			user.setStaffId(request.getParameter("staffId"));
			user.setLoginName(request.getParameter("loginName"));
			user.setGender(request.getParameter("gender"));
			user.setDepartment(request.getParameter("department"));
			user.setState(request.getParameter("state"));
			user.setIsAdmin(request.getParameter("isAdmin"));
			user.setEmail(request.getParameter("email"));
			user.setMobilePhone(request.getParameter("mobilePhone"));
			user.setMemo(request.getParameter("memo"));
			User currUser=(User) session.getAttribute(Constants.SESSION_USER);
			user.setUpdateUser(currUser.getLoginId());
			String password=request.getParameter("password");
			if(password!=null||password!="") {				
				Encrypt encrypt = new Encrypt();
				password=encrypt.encode(password);
				user.setPassword(password);
			}
			userService.updateUser(user);
			String roles=request.getParameter("roles");
			if(roles!=""&&roles!=null) {
				String[] role= roles.split(",");
				RoleUser roleUser=new RoleUser();
				roleuserService.deleteRoleByloginId(loginId);
				roleUser.setUserId(currUser.getLoginId());
				roleUser.setLoginId(user.getLoginId());
				for(int i=0;i<role.length;i++){
					roleUser.setRoleId(role[i]);
					roleuserService.insertUserRole(roleUser);
				}
			}
			session.setAttribute(Constants.SESSION_USER, user);
			map.put("state", 0);
			map.put("msg", "修改成功");
		} catch (Exception e) {
			map.put("state", -1);
			map.put("msg", e.getMessage());
		}
		return getJsonResponseEntity(map); 
	}

	//修改密码
	@RequestMapping(value="/updatePassword.do",method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> updatePassword(
			String loginId,String oldPwd,String newPwd){
		Map<String, Object> map=new HashMap<String, Object>();
		try{
			Encrypt encrypt = new Encrypt();
			oldPwd=encrypt.encode(oldPwd);
			newPwd=encrypt.encode(newPwd);
			userService.changePassword(loginId,oldPwd, newPwd);
			map.put("state", 0);
			map.put("msg", "修改成功");
		}catch(PassWordNotFoundException e){
			map.put("state", -1);
			map.put("msg", e.getMessage());
		}catch(Exception e) {
			map.put("state", -1);
			map.put("msg", "服务异常,修改失败");
		}
		return getJsonResponseEntity(map); 
	}

	//注销用户
	@RequestMapping("/deleteUser.do")
	public @ResponseBody ResponseEntity<String> deleteUser(String loginId){
		Map<String, Object> map=new HashMap<String, Object>();
		try{
			userService.logOffUser(loginId);
			map.put("state", 0);
			map.put("msg", "注销成功");
		}catch(RuntimeException e){
			map.put("state", -1);
			map.put("msg", "注销失败");
		}
		return getJsonResponseEntity(map); 
	}
}
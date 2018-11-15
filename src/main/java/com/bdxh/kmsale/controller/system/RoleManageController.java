package com.bdxh.kmsale.controller.system;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdxh.kmsale.bean.AbstractEntity;
import com.bdxh.kmsale.bean.ConditionResource;
import com.bdxh.kmsale.bean.system.Menu;
import com.bdxh.kmsale.bean.system.Role;
import com.bdxh.kmsale.bean.system.RolePermissions;
import com.bdxh.kmsale.bean.system.User;
import com.bdxh.kmsale.common.Constants;
import com.bdxh.kmsale.controller.AbstractBackendController;
import com.bdxh.kmsale.service.system.MenuService;
import com.bdxh.kmsale.service.system.RolePermissionsService;
import com.bdxh.kmsale.service.system.RoleService;
import com.bdxh.kmsale.service.system.RoleUserService;

/**
 * 角色管理Controller
 * @author 莫夏欣 2018.10.25
 *
 */
@Controller
@RequestMapping("/manage/role")
public class RoleManageController extends AbstractBackendController<AbstractEntity, Long>{
	@Resource
	private RoleService roleService;
	@Resource
	private MenuService menuService;
	@Resource
	private RolePermissionsService rps;
    //显示角色列表
	@RequestMapping("/list")
	public String showRoleList() {
		return "system/listRole";
	}
	
	//显示添加角色
	@RequestMapping("/showAdd")
	public String showRoleAdd() {
		return "system/addRole";
	}
	//显示修改用户界面
	@RequestMapping("/showUpdate")
	public String showUpdate() {
		return "system/editRole";
	}
	
    //输出全部角色列表
	@RequestMapping("/listAll")
	public @ResponseBody ResponseEntity<String> listAll() {
	Map<String, Object> map=new HashMap<String, Object>();
		List<Role> roles=roleService.selectRoleByAll();
		map.put("roles", roles);
	  return getJsonResponseEntity(map); 
	 }
	//输出角色列表(分页)
	@RequestMapping(value="/toList",method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> roleList(
			@RequestBody ConditionResource conditionResource){
		Integer pageCurrent=conditionResource.getPageCurrent();//当前页
		if(pageCurrent==null||pageCurrent==0||pageCurrent.equals("")){
			pageCurrent=1;
		}
		conditionResource.setPageCurrent(pageCurrent);
		if(conditionResource.getName()==""){
			conditionResource.setName(null);
		}
		if(conditionResource.getId()==""){
			conditionResource.setId(null);
		}
		//一共多少用户
		Integer roleCountAll=roleService.selectRoleCountAll();
		//条件查询返回数
		Integer roleCountCondition=roleService.selectRoleCountCondition(conditionResource);
		//每页显示的数据
		Integer pageSize=conditionResource.getPageSize();
		//总页数
		Integer pageCount = (roleCountCondition + pageSize - 1) / pageSize;
		if(conditionResource.getPageCurrent()>pageCount){
			conditionResource.setPageCurrent(pageCount);
				pageCurrent=pageCount;
		}
		List<Role> roles=roleService.selectListRole(conditionResource);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("roles", roles);
		//总数
		map.put("roleCountAll", roleCountAll);
		//条件查询返回的总数
		map.put("roleCountCondition", roleCountCondition);
		//每页显示的数据
		map.put("pageSize", pageSize);
		//总页数
		map.put("pageCount", pageCount);
		//当前页
		map.put("pageCurrent", pageCurrent);
	    return getJsonResponseEntity(map);
	}
	
	//查询所有角色id和姓名
	@RequestMapping(value="/selectRoleAll")
	public @ResponseBody ResponseEntity<String> selectRoleAll(){
		Map<String, Object> map=new HashMap<String, Object>();
		List<Role> roles=roleService.selectRoleByAll();
		map.put("roles", roles);
		return getJsonResponseEntity(map);
	}
	
	//添加角色
	@RequestMapping(value="/addRole",method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> addRole(
			@RequestBody Role role,
			HttpSession session) throws ParseException{
		Map<String, Object> map=new HashMap<String, Object>();
	 	try {
			//查询所有菜单
			User currUser=(User) session.getAttribute(Constants.SESSION_USER);
			role.setUpdateUser(currUser.getLoginId());
			roleService.insertRole(role);
			List<Menu> menus=menuService.selectMenuList(null);
			RolePermissions rp=new RolePermissions();
			rp.setAuthRead("0");
			rp.setAuthCreate("0");
			rp.setAuthDelete("0");
			rp.setAuthUpdate("0");
			rp.setUpdateUser(currUser.getLoginId());
			rp.setRoleId(role.getRoleId());
			for(int i=0;i<menus.size();i++) {
				rp.setModuleId(menus.get(i).getModuleId());
				rps.insertPermissions(rp);
			}
			map.put("state", 0);
			map.put("msg", "添加成功");
 		  }catch (Exception e) {
			map.put("state", -1);
			map.put("msg", e.getMessage());
		}
		return getJsonResponseEntity(map); 
	}
	
	//显示用户数据
	@RequestMapping(value="/showRole",method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> showUser(
			@RequestParam(value="roleId",required=false) String roleId){
		Map<String, Object> map=new HashMap<String, Object>();
		Role role=roleService.selectRoleById(roleId);
		map.put("role", role);
		return getJsonResponseEntity(map); 
	}
	//修改用户
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> updateRole(
			HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session){
		Map<String, Object> map=new HashMap<String, Object>();
		try {
			Role role=new Role();
			role.setRoleId(request.getParameter("roleId"));
			role.setRoleName(request.getParameter("roleName"));
			User currUser=(User) session.getAttribute(Constants.SESSION_USER);
			role.setUpdateUser(currUser.getLoginId());
			roleService.updateRole(role);
			map.put("state", 0);
			map.put("msg", "修改成功");
		} catch (Exception e) {
			map.put("state", -1);
			map.put("msg", e.getMessage());
		}
		return getJsonResponseEntity(map); 
	}

	//删除角色
	@RequestMapping("/deleteRole")
	public @ResponseBody ResponseEntity<String> deleteRole(String roleId){
		Map<String, Object> map=new HashMap<String, Object>();
		try{
			roleService.deleteRole(roleId);
			//删除角色对应权限
			rps.deletePermissionsByRoleId(roleId);
			map.put("state", 0);
			map.put("msg", "删除成功");
		}catch(RuntimeException e){
			map.put("state", -1);
			map.put("msg", "删除失败");
		}
		return getJsonResponseEntity(map); 
	}
}

package com.bdxh.kmsale.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdxh.kmsale.bean.AbstractEntity;
import com.bdxh.kmsale.bean.system.Menu;
import com.bdxh.kmsale.bean.system.Role;
import com.bdxh.kmsale.bean.system.RolePermissions;
import com.bdxh.kmsale.bean.system.User;
import com.bdxh.kmsale.common.Constants;
import com.bdxh.kmsale.controller.AbstractBackendController;
import com.bdxh.kmsale.service.system.MenuService;
import com.bdxh.kmsale.service.system.RolePermissionsService;
import com.bdxh.kmsale.service.system.RoleService;

@Controller
@RequestMapping("/manage/permissions")
public class PermissionsController extends AbstractBackendController<AbstractEntity, Long>{
	@Resource
	private RoleService roleService;
	@Resource
	private MenuService menuService;
	@Resource
	private RolePermissionsService rps;
	//显示权限列表
	@RequestMapping("/list")
	public String showPermissionsList() {
		return "system/listPermissions";
	}
	//显示修改用户界面
	@RequestMapping("/showUpdate")
	public String showUpdate() {
		return "system/editPermissions";
	}
	
	//显示用户数据
	@RequestMapping(value="/showPermissions",method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> showUser(
			@RequestParam(value="roleId",required=false) String roleId){
		Map<String, Object> map=new HashMap<String, Object>();
		List<Menu> menus=menuService.selectMenuList(null);
		Role role=roleService.selectRoleById(roleId);
		List<RolePermissions> rpses=rps.selecPermissionsByRoleId(roleId);
		map.put("menus", menus);
		map.put("role", role);
		map.put("rpses", rpses);
		return getJsonResponseEntity(map); 
	}

	//显示用户数据
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> update(
			@RequestBody RolePermissions rolePermissions,
			HttpSession session){
		Map<String, Object> map=new HashMap<String, Object>();
		try {
			User currUser=(User) session.getAttribute(Constants.SESSION_USER);
			rolePermissions.setUpdateUser(currUser.getLoginId());
			rps.updatePermissions(rolePermissions);
			map.put("state", 1);
			map.put("msg", "授权成功");
		} catch (Exception e) {
			map.put("state", -1);
			map.put("msg", "授权失败");
		}
		return getJsonResponseEntity(map); 
	}
}

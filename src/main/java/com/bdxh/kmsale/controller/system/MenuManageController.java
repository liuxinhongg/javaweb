package com.bdxh.kmsale.controller.system;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdxh.kmsale.bean.AbstractEntity;
import com.bdxh.kmsale.bean.system.Menu;
import com.bdxh.kmsale.bean.system.NavMenu;
import com.bdxh.kmsale.bean.system.Role;
import com.bdxh.kmsale.bean.system.RolePermissions;
import com.bdxh.kmsale.bean.system.TreeMenu;
import com.bdxh.kmsale.bean.system.User;
import com.bdxh.kmsale.cache.redis.RedisTemplate;
import com.bdxh.kmsale.common.Constants;
import com.bdxh.kmsale.controller.AbstractBackendController;
import com.bdxh.kmsale.service.system.MenuService;
import com.bdxh.kmsale.service.system.RolePermissionsService;
import com.bdxh.kmsale.service.system.RoleService;
import com.bdxh.kmsale.utils.CookiesUtil;

import net.sf.json.JSONArray;

/**
 * 菜单管理Controller
 * @author 莫夏欣 2018.10.25
 *
 */
@Controller
@RequestMapping("/manage/menu")
public class MenuManageController extends AbstractBackendController<AbstractEntity, Long>{
	protected RedisTemplate redisTemplate = RedisTemplate.getInstance();
	@Resource
	private RoleService roleService;
	@Resource
	private MenuService menuService;
	@Resource
	private RolePermissionsService rps;

	//显示菜单列表
	@RequestMapping("/list")
	public String showMenuList() {
		return "system/listMenu";
	}

	//显示添加菜单
	@RequestMapping("/showAdd")
	public String showRoleAdd() {
		return "system/addMenu";
	}

	//显示修改用户界面
	@RequestMapping("/showUpdate")
	public String showUpdate() {
		return "system/editMenu";
	}
	//显示用户数据
	@RequestMapping(value="/showMenu",method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> showUser(
			@RequestParam(value="id",required=false) String id){
		Map<String, Object> map=new HashMap<String, Object>();
		Menu menu=menuService.selectMenu(id);
		map.put("menu", menu);
		return getJsonResponseEntity(map); 
	}
	//查询菜单树状
	@RequestMapping(value="/toList",method =RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> showList(
			HttpServletRequest request,
			HttpServletResponse response){
		Map<String, Object> map=new HashMap<String, Object>();
		List<Menu> rootMenu=redisTemplate.get("menu");
		if(rootMenu==null) {
			rootMenu=menuService.selectMenuList(null);
			redisTemplate.setex("menu", rootMenu,24*60*60);
		}
		List<TreeMenu> treeMenu=treeChild(rootMenu);
		List<NavMenu> navMenu=treeChild2(rootMenu);
		JSONArray treeMenuArray=JSONArray.fromObject(treeMenu);
		JSONArray navMenuArray=JSONArray.fromObject(navMenu);
		map.put("treeMenu", treeMenuArray);
		map.put("navMenu", navMenuArray);
		return getJsonResponseEntity(map); 
	}
	//查询菜单
	@RequestMapping(value="/rootMenu",method =RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> rootMenu(){
		Map<String, Object> map=new HashMap<String, Object>();
		List<Menu> rootMenu=menuService.selectMenuList(null);
		map.put("rootMenu", rootMenu);
		return getJsonResponseEntity(map); 
	}
	//查询菜单
	@RequestMapping(value="/selectMenuAll",method =RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> selectMenuAll(){
		Map<String, Object> map=new HashMap<String, Object>();
		List<Menu> rootMenu=menuService.selectMenuList(null);
		map.put("rootMenu", rootMenu);
		return getJsonResponseEntity(map);
	}


	//添加菜单
	@RequestMapping(value="/addMenu",method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> addMenu(
			@RequestBody Menu menu,
			HttpSession session){
		Map<String, Object> map=new HashMap<String, Object>();
		try {
			menuService.insertMenu(menu);
			User user=(User) session.getAttribute(Constants.SESSION_USER);
			//查询所有菜单
			List<Role> roles=roleService.selectRoleByAll();
			RolePermissions rp=new RolePermissions();
			rp.setAuthRead("0");
			rp.setAuthCreate("0");
			rp.setAuthDelete("0");
			rp.setAuthUpdate("0");
			rp.setUpdateUser(user.getLoginId());
			rp.setModuleId(menu.getModuleId());
			for(int i=0;i<roles.size();i++) {
				rp.setRoleId(roles.get(i).getRoleId());
				rps.insertPermissions(rp);
			}
			redisTemplate.del("menu");
			map.put("state", 0);
			map.put("msg", "添加成功");
		} catch (Exception e) {
			map.put("state", -1);
			map.put("msg", e.getMessage());
		}
		return getJsonResponseEntity(map); 
	}

	//修改菜单
	@RequestMapping(value="/updateMenu",method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> updateMenu(
			@RequestBody Menu menu){
		Map<String, Object> map=new HashMap<String, Object>();
		try {
			menuService.updateMenu(menu);
			redisTemplate.del("menu");
			map.put("state", 0);
			map.put("msg", "修改成功");
		} catch (Exception e) {
			map.put("state", -1);
			map.put("msg", "修改失败");
		}
		return getJsonResponseEntity(map); 
	}

	//删除菜单
	@RequestMapping("/deleteMenu.do")
	public @ResponseBody ResponseEntity<String> deleteMenu(
			@RequestParam(value="id",required=false) String id){
		Map<String, Object> map=new HashMap<String, Object>();
		try{
			//根据父级ID查询子菜单
			List<Menu> menus=menuService.selectMenuList(id);
			menuService.deleteMenu(id);
			rps.deletePermissionsBymoduleId(id);
			for(int i=0;i<menus.size();i++) {
				menuService.deleteMenuByparentId(menus.get(i).getParentId());
				rps.deletePermissionsBymoduleId(menus.get(i).getModuleId());
			}
			redisTemplate.del("menu");
			map.put("state", 0);
			map.put("msg", "删除成功");
		}catch(RuntimeException e){
			map.put("state", -1);
			map.put("msg", "删除失败");
		}
		return getJsonResponseEntity(map); 
	}

	//菜单树状的处理
	private static List<TreeMenu> treeChild(List<Menu> rootMenu) {
		List<TreeMenu> treeMenu = new ArrayList<TreeMenu>();
		for (int i = 0; i < rootMenu.size(); i++) {
			// 一级菜单没有IsParent为1
			TreeMenu tm=new TreeMenu();
			if (rootMenu.get(i).getParentId().equals("kb_menu_root")) {
				tm.setId(rootMenu.get(i).getModuleId());
				tm.setName(rootMenu.get(i).getModuleName());
				tm.setChecked(false);
				tm.setChildren(getChild(rootMenu.get(i).getModuleId(),rootMenu));
				treeMenu.add(tm);
			}
		}	
		return treeMenu;
	}

	private static List<TreeMenu> getChild(
			String moduleId, List<Menu> rootMenu) {
		// 子菜单
		List<TreeMenu> childList = new ArrayList<TreeMenu>();
		// 把子菜单的子菜单再循环一遍
		for (int i=0;i<rootMenu.size();i++) {
			if (rootMenu.get(i).getParentId().equals(moduleId)){
				TreeMenu tm=new TreeMenu();
				// 递归
				tm.setId(rootMenu.get(i).getModuleId());
				tm.setName(rootMenu.get(i).getModuleName());
				tm.setChecked(false);
				tm.setChildren(getChild(rootMenu.get(i).getModuleId(), rootMenu));
				childList.add(tm);
			}
		} 
		// 递归退出条件
		if (childList.size() == 0) {
			return null;
		}
		return childList;
	}

	//菜单树状的处理
	private static List<NavMenu> treeChild2(List<Menu> rootMenu) {
		List<NavMenu> navMenu = new ArrayList<NavMenu>();
		for (int i = 0; i < rootMenu.size(); i++) {
			// 一级菜单没有IsParent为1
			NavMenu nm=new NavMenu();
			if (rootMenu.get(i).getParentId().equals("kb_menu_root")) {
				nm.setTitle(rootMenu.get(i).getModuleName());
				nm.setHref(rootMenu.get(i).getUrl());
				nm.setSpread(false);
				nm.setIcon("&#xe63c;");
				nm.setChildren(getChild2(rootMenu.get(i).getModuleId(),rootMenu));
				navMenu.add(nm);
			}
		}	
		return navMenu;
	}

	private static List<NavMenu> getChild2(
			String moduleId, List<Menu> rootMenu) {
		// 子菜单
		List<NavMenu> childList = new ArrayList<NavMenu>();
		// 把子菜单的子菜单再循环一遍
		for (int i=0;i<rootMenu.size();i++) {
			if (rootMenu.get(i).getParentId().equals(moduleId)){
				NavMenu nm=new NavMenu();
				// 递归
				nm.setTitle(rootMenu.get(i).getModuleName());
				nm.setHref(rootMenu.get(i).getUrl());
				nm.setSpread(false);
				nm.setIcon("&#xe621;");
				nm.setChildren(getChild2(rootMenu.get(i).getModuleId(), rootMenu));
				childList.add(nm);
			}
		} 
		// 递归退出条件
		if (childList.size() == 0) {
			return null;
		}
		return childList;
	}
}
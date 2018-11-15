package com.bdxh.kmsale.service.system;

import java.util.List;

import com.bdxh.kmsale.bean.system.Menu;
/**
 * 菜单管理
 * @author 莫夏欣
 *
 */
public interface MenuService{
	Menu selectMenu(String moduleId);
	List<Menu> selectMenuList(String parentId);
	void insertMenu(Menu menu);
	void updateMenu(Menu menu);
	void deleteMenu(String moduleId);
	void deleteMenuByparentId(String parentId);
	boolean selectCountMenu(String moduleId);
}

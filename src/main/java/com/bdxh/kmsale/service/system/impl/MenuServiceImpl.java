package com.bdxh.kmsale.service.system.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bdxh.kmsale.bean.system.Menu;
import com.bdxh.kmsale.mapper.system.MenuMapper;
import com.bdxh.kmsale.service.ex.ObjectNotFoundException;
import com.bdxh.kmsale.service.system.MenuService;

/**
 * 菜单管理
 * @author 莫夏欣
 *
 */
@Service
public class MenuServiceImpl implements MenuService{
	@Resource
	private MenuMapper menuMapper;
	
	@Override
	public Menu selectMenu(String moduleId) {
		return menuMapper.selectMenu(moduleId);
	}
	
	@Override
	public List<Menu> selectMenuList(String parentId) {
		return menuMapper.selectMenuList(parentId);
	}
	
	@Override
	public void insertMenu(Menu menu) {
		if(menuMapper.selectMenu(menu.getModuleId())!=null) {
			throw new ObjectNotFoundException("模块ID已经存在!");
		}else {		
			menuMapper.insertMenu(menu);
		}
	}
	
	@Override
	public void updateMenu(Menu newMenu) {
	  menuMapper.updateMenu(newMenu);
	}
	
	@Override
	public void deleteMenu(String moduleId) {
		menuMapper.deleteMenu(moduleId);
	}
	@Override
	public boolean selectCountMenu(String moduleId) {
		return menuMapper.selectMenu(moduleId)!=null;
	}

	@Override
	public void deleteMenuByparentId(String parentId) {
		menuMapper.deleteMenuByParentId(parentId);
	}
}

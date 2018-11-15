package com.bdxh.kmsale.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bdxh.kmsale.bean.system.Menu;

public interface MenuMapper {
	//根据ID查询
	Menu selectMenu(String moduleId);
	/**
	 * 
	 * @param parentId 为空则查全部
	 * @return
	 */
	List<Menu> selectMenuList(@Param(value="parentId") String parentId);
	void insertMenu(Menu menu);
	void updateMenu(Menu menu);
	void deleteMenu(String moduleId);
	void deleteMenuByParentId(String parentId);
}

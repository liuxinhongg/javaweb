package com.bdxh.kmsale.bean.system;

import java.io.Serializable;
import java.util.List;
/**
 * 
 * @author 莫夏欣
 * @date 创建时间：2018年10月25日,上午10:35:18
 * @Description 菜单
 */
public class Menu implements Serializable{
	private static final long serialVersionUID = -9162374351617705044L;
	private String moduleId;
	private String moduleName;
	private String moduleType;
	private String parentId;
	private String url;
	private long ord;
	private String toggle;
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getModuleType() {
		return moduleType;
	}
	public void setModuleType(String moduleType) {
		this.moduleType = moduleType;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public long getOrd() {
		return ord;
	}
	public void setOrd(long ord) {
		this.ord = ord;
	}
	public String getToggle() {
		return toggle;
	}
	public void setToggle(String toggle) {
		this.toggle = toggle;
	}
	@Override
	public String toString() {
		return "Menu [moduleId=" + moduleId + ", moduleName=" + moduleName + ", moduleType=" + moduleType
				+ ", parentId=" + parentId + ", url=" + url + ", ord=" + ord + ", toggle=" + toggle + "]";
	}

}

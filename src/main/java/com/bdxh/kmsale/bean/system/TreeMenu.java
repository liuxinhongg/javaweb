package com.bdxh.kmsale.bean.system;

import java.io.Serializable;
import java.util.List;
/**
 * 
 * @author 莫夏欣
 * @date 创建时间：2018年11月1日,上午10:36:39
 * @Description 菜单输出树状图
 */
public class TreeMenu implements Serializable{
	private static final long serialVersionUID = -6297945984041116852L;
	private String id;
	private String name;
	private boolean checked;
	private List<TreeMenu> children;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public List<TreeMenu> getChildren() {
		return children;
	}
	public void setChildren(List<TreeMenu> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "TreeMenu [id=" + id + ", name=" + name + ", checked=" + checked + ", children=" + children + "]";
	}

}

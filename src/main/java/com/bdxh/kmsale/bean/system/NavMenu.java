package com.bdxh.kmsale.bean.system;

import java.io.Serializable;
import java.util.List;
/**
 * 
 * @author 莫夏欣
 * @date 创建时间：2018年11月7日,上午10:34:46
 * @Description 菜单树状图
 */
public class NavMenu implements Serializable{
	private static final long serialVersionUID = 3184463177643470723L;
	private String title;
	private String icon;
	private String href;
	private boolean spread;
	private List<NavMenu> children;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public boolean isSpread() {
		return spread;
	}
	public void setSpread(boolean spread) {
		this.spread = spread;
	}
	public List<NavMenu> getChildren() {
		return children;
	}
	public void setChildren(List<NavMenu> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "NavMenu [title=" + title + ", icon=" + icon + ", href=" + href + ", spread=" + spread + ", children="
				+ children + "]";
	}
	
}

package com.bdxh.kmsale.bean;

import java.io.Serializable;

/**
 * 
 * @author 莫夏欣
 * @date 创建时间：2018年11月7日,下午4:07:31
 * @Description  公用查询条件(id、名称、状态、分页)
 */
public class ConditionResource implements Serializable{
	private static final long serialVersionUID = -1991089918052935779L;
	private String id;//id
	private String name;//用户名
	private String state;//状态
	private Integer pageCurrent;//当前页
	private Integer pageSize;//一页显示数据的数量
	private Integer startPos;//查询的起始条数
	private Integer endPos;//结束条数
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public Integer getPageCurrent() {
		return pageCurrent;
	}
	public void setPageCurrent(Integer pageCurrent) {
		this.pageCurrent = pageCurrent;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getStartPos() {
		startPos=(pageCurrent-1)*pageSize;
		return startPos;
	}
	public void setStartPos(Integer startPos) {
		this.startPos = startPos;
	}
	public Integer getEndPos() {
		endPos=pageCurrent*pageSize;
		return endPos;
	}
	public void setEndPos(Integer endPos) {
		this.endPos = endPos;
	}
	@Override
	public String toString() {
		return "ConditionResource [id=" + id + ", name=" + name + ", state=" + state + ", pageCurrent=" + pageCurrent
				+ ", pageSize=" + pageSize + ", startPos=" + startPos + ", endPos=" + endPos + "]";
	}

}

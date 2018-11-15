package com.bdxh.kmsale.domain;

import java.io.Serializable;

public class Paging implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -1496683860213751587L;
	
	private Integer pageCurrent;//当前页
	private Integer pageSize;//一页显示数据的数量
	private Integer startPos;//查询的起始条数
	private Integer endPos;//结束条数
	
	public Integer getPageCurrent() {
		return pageCurrent;
	}
	public void setPageCurrent(Integer pageCurrent) {
		this.pageCurrent = pageCurrent;
	}
	public Integer getStartPos() {
		startPos=(pageCurrent-1)*pageSize;
		return startPos;
	}
	public void setStartPos(Integer startPos) {
		this.startPos = startPos;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getEndPos() {
		endPos=pageCurrent*pageSize;
		return endPos;
	}
	public void setEndPos(Integer endPos) {
		this.endPos = endPos;
	}
}

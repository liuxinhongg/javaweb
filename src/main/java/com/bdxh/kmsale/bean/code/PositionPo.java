package com.bdxh.kmsale.bean.code;

import java.io.Serializable;
import java.util.Date;

public class PositionPo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6352464778777133485L;
	
	private Integer id;
	
	private String positionName;
	
	private Double positionComm;
	
	private Date createDate;
	
	private String operId;
	
	private Integer ord;
	
	private Integer status;
	
	private String positionDesc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public Double getPositionComm() {
		return positionComm;
	}

	public void setPositionComm(Double positionComm) {
		this.positionComm = positionComm;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getOperId() {
		return operId;
	}

	public void setOperId(String operId) {
		this.operId = operId;
	}

	public Integer getOrd() {
		return ord;
	}

	public void setOrd(Integer ord) {
		this.ord = ord;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getPositionDesc() {
		return positionDesc;
	}

	public void setPositionDesc(String positionDesc) {
		this.positionDesc = positionDesc;
	}
}

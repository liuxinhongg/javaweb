package com.bdxh.kmsale.bean.code;

import java.io.Serializable;

public class DeviceTypePo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4787643497750555322L;

	private String codeId;
	
	private String codeDesc;
	
	private Integer status;
	
	private Integer ord;

	public String getCodeId() {
		return codeId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	public String getCodeDesc() {
		return codeDesc;
	}

	public void setCodeDesc(String codeDesc) {
		this.codeDesc = codeDesc;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getOrd() {
		return ord;
	}

	public void setOrd(Integer ord) {
		this.ord = ord;
	}
}

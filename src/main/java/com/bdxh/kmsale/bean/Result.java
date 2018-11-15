package com.bdxh.kmsale.bean;

import java.io.Serializable;

public class Result implements Serializable {

	private static final long serialVersionUID = -3412474003712855976L;

	private Integer resultCode;
	private String resultDesc;
	private Object resultObject;

	public Integer getResultCode() {
		return this.resultCode;
	}

	public void setResultCode(Integer resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultDesc() {
		return this.resultDesc;
	}

	public void setResultDesc(String resultDesc) {
		this.resultDesc = resultDesc;
	}

	public Object getResultObject() {
		return this.resultObject;
	}

	public void setResultObject(Object resultObject) {
		this.resultObject = resultObject;
	}
}

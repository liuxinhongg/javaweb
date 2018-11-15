package com.bdxh.kmsale.bean.inventory;

import java.io.Serializable;

public class NumberType implements Serializable{

	/**
	 * 靓号类型表
	 */
	private static final long serialVersionUID = 1L;
	
	private String level_type;

	public String getLevel_type() {
		return level_type;
	}

	public void setLevel_type(String level_type) {
		this.level_type = level_type;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}

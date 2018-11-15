package com.bdxh.kmsale.bean.system;

import java.io.Serializable;
/**
 * 
 * @author 莫夏欣
 * @date 创建时间：2018年10月20日,上午10:35:54
 * @Description 返回状态及提示
 */
public class ResponseResult implements Serializable {
	private static final long serialVersionUID = 7550442801508562900L;
	private Integer state;
	private String message;
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ResponseResult [state=" + state + ", message=" + message + "]";
	}

}

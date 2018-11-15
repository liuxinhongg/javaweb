package com.bdxh.kmsale.service.ex;
/**
 * 密码错误抛出异常
 * @author 莫夏欣
 *
 */
public class PassWordNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 3260827032262987737L;

	public PassWordNotFoundException(){

	}
	public PassWordNotFoundException (String msg){
		super(msg);
	}

}

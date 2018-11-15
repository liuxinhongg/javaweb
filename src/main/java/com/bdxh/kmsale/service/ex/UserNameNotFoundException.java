package com.bdxh.kmsale.service.ex;
/**
 * 用户名错误配抛出异常
 * @author 莫夏欣
 *
 */
public class UserNameNotFoundException extends RuntimeException{
	private static final long serialVersionUID = -3698096686317913259L;
	public UserNameNotFoundException(){
	}
	public UserNameNotFoundException(String msg){
		super(msg);
	}
}

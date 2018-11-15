package com.bdxh.kmsale.service.ex;

public class ObjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -2956047121920959801L;
	public ObjectNotFoundException(){

	}
	public ObjectNotFoundException (String msg){
		super(msg);
	}

}

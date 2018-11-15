package com.bdxh.kmsale.utils;

public class Encrypt {

	private String encryptType = "MD5";

	public String encode(String plainText) {
		String md5Str = MD5.getDoubleMD5(plainText);

		return md5Str;
	}

	public void setEncryptType(String encryptType) {
		this.encryptType = encryptType;
	}

}

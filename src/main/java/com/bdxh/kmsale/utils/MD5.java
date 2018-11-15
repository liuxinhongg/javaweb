package com.bdxh.kmsale.utils;

import java.security.MessageDigest;

public class MD5 {

	public static String getDoubleMD5(String plainText)
	  {
	    return getMD5Cipher(getMD5Cipher(plainText));
	  }
	  
	  private static String getMD5Cipher(String plainText)
	  {
	    char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
	    try
	    {
	      MessageDigest mdTemp = MessageDigest.getInstance("MD5");
	      mdTemp.update(plainText.getBytes());
	      byte[] md = mdTemp.digest();
	      int j = md.length;
	      char[] cipher = new char[j * 2];
	      int k = 0;
	      for (int i = 0; i < j; i++)
	      {
	        byte byte0 = md[i];
	        cipher[(k++)] = hexDigits[(byte0 >>> 4 & 0xF)];
	        cipher[(k++)] = hexDigits[(byte0 & 0xF)];
	      }
	      return new String(cipher);
	    }
	    catch (Exception e) {}
	    return null;
	  }
}

package com.bdxh.kmsale.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.apache.commons.lang3.StringUtils;

@SuppressWarnings({ "serial", "finally" })
public class ObjectSerialize implements Serializable {

	public static String serialization(Object obj) {
		String result = StringUtils.EMPTY;
		ObjectOutputStream oos = null;
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.writeObject(obj);
			result = bos.toString("ISO-8859-1");
			result = URLEncoder.encode(result, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null) {
					oos.close();
					oos = null;
				}
			} catch (Exception e) {
			}
			return result;
		}

	}

	public static Object deserialization(String serial) {
		if (StringUtils.isBlank(serial)) {
			return null;
		}
		ObjectInputStream ois = null;
		Object result = null;
		try {
			String str = URLDecoder.decode(serial, "UTF-8");
			ByteArrayInputStream bis = new ByteArrayInputStream(str.getBytes("ISO-8859-1"));
			ois = new ObjectInputStream(bis);
			result = ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null) {
					ois.close();
					ois = null;
				}
			} catch (Exception e) {
			}
			return result;
		}
	}

	public static void main(String[] args) {
		System.out.println(ObjectSerialize.serialization(new ObjectSerialize()));
	}
}

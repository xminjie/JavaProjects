package com.njwb.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;



public class MD5Util{

	public static String enc(String password){
		try {
			MessageDigest md=MessageDigest.getInstance("MD5");
			byte[] b=md.digest(password.getBytes());
			BASE64Encoder encoder=new BASE64Encoder();
			String pass = encoder.encode(b);
			return pass.substring(0,pass.length()-2);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		String s1=enc("12312321321");
		String s=enc("2");
		System.out.println(s + "\n"+s1);
	}
}

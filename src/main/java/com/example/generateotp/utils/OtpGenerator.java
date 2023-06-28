package com.example.generateotp.utils;

import java.security.SecureRandom;

public class OtpGenerator {
	
	public static String getSystemGeneratedPassword(int length) {
	    final String ab = "0123456789";

	    SecureRandom rnd = new SecureRandom();
	    StringBuilder sb = new StringBuilder(length);
	    for (int i = 0; i < length; i++) {
	      sb.append(ab.charAt(rnd.nextInt(ab.length())));
	    }
	    return sb.toString();
	  }
}
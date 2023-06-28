package com.example.generateotp.entity;

import lombok.Data;

@Data
public class OTPRequest {
	
	private String otp;
	private String to;

}

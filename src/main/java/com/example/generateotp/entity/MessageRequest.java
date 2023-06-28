package com.example.generateotp.entity;

import lombok.Data;

@Data
public class MessageRequest {
	
	private String message;
	private String to;

}

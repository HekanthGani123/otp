package com.example.generateotp.controller;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.generateotp.entity.MessageRequest;
import com.example.generateotp.service.TwilioService;

@RestController
public class MessageController {
    
	private static final Logger logger = LoggerFactory.getLogger(MessageController.class);
	
    private final TwilioService twilioService;
    
    @Autowired
    public MessageController(TwilioService twilioService) {
        this.twilioService = twilioService;
    }
    
    @PostMapping("/send-message-otp")
    public ResponseEntity<String>  sendMessage(@RequestBody MessageRequest request) {
    	try {
        twilioService.sendMessage(request.getTo(), request.getMessage());
        return ResponseEntity.of(Optional.of("msg and otp send"));
    	}catch(Exception e) {
    		logger.info("Exception occurs :"+e.getMessage());
    		return new ResponseEntity<String>("failed to store", HttpStatus.NOT_FOUND);
    	}
    }
    
 
}

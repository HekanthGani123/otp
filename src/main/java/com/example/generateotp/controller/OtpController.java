package com.example.generateotp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.generateotp.entity.GenerateMobileOtp;
import com.example.generateotp.service.OtpService;

@RestController
public class OtpController {

    @Autowired
    private OtpService otpService;

    @PostMapping("/generate-otp")
    public void generateOtp(@RequestBody GenerateMobileOtp mobileNumber) {
        otpService.generateAndSendOtp(mobileNumber.getMobileno());
    }
}


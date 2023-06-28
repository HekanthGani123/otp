package com.example.generateotp.service;
import com.example.generateotp.utils.OtpGenerator;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TwilioService {
    
    @Value("${twilio.account.sid}")
    private String accountSid;
    
    @Value("${twilio.auth.token}")
    private String authToken;
    
    public void sendMessage(String to, String message) {
        PhoneNumber from = new PhoneNumber("+14178052967");
        PhoneNumber toNumber = new PhoneNumber(to);
        String otp = OtpGenerator.getSystemGeneratedPassword(4);
        String msg=message+" your iso_engine otp is: "+otp;
        Message create = Message.creator(toNumber, from, msg).create();
        System.out.println(create.getBody());
    }
    
    public void sendOTP(String to, String otp) {
        String message = "Your OTP is: " + otp;
        sendMessage(to, message);
    }
}

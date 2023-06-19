package com.example.generateotp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.verify.v2.service.Verification;
import com.twilio.type.PhoneNumber;

@Service
public class OtpService {

    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

//    @Value("${twilio.phone.number}")
//    private String twilioPhoneNumber;

    public void generateAndSendOtp(String mobileNumber) {
        Twilio.init(accountSid, authToken);
        
        try {
            Verification verification = Verification.creator(
                "VA6b3acc9ac3b111cd44d35ac40a24ba31", // Your Verify Service SID
                mobileNumber,
                "sms"
            ).create();

            // Handle the verification initiation response
            System.out.println("OTP sent successfully");
        } catch (ApiException e) {
            // Handle any errors that occurred during OTP generation and sending
            System.out.println(e.getMessage());
        }

        // Generate a random 6-digit OTP
        String otp = String.format("%06d", (int) (Math.random() * 1000000));

//         Create a Twilio message and send it
//        Message message = Message.creator(
//                new PhoneNumber(mobileNumber),
//                new PhoneNumber(mobileNumber),
//                "Your OTP is: " + otp)
//                .create();

        System.out.println("OTP sent successfully: " + otp);
       
    }
}


package com.example.generateotp.config;
import com.twilio.Twilio;

public class TwilioInitializer {
    public static final String ACCOUNT_SID = "AC7d3019a70663efd78c5bbdb588a2b134";
    public static final String AUTH_TOKEN = "690942537519cc83d0086691441bc9a5";

    public static void initialize() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }
}

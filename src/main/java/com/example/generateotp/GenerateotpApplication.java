package com.example.generateotp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import com.example.generateotp.config.TwilioInitializer;

@SpringBootApplication
public class GenerateotpApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenerateotpApplication.class, args);
	}
	
	@EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        TwilioInitializer.initialize();
    }

}

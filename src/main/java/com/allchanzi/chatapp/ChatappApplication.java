package com.allchanzi.chatapp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;


@SpringBootApplication
public class ChatappApplication {

	public static void main(String[] args) {

		SpringApplication.run(ChatappApplication.class, args);
		System.out.println("Up and running!!!");
	}

}

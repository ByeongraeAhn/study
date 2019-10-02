package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class AdminApplication {
	// 어드민 주소 : http://localhost:7070
	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}

}

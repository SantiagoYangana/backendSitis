package com.sitis.prueba.backendSitis;

import com.sitis.prueba.backendSitis.service.UserService;
import com.sitis.prueba.backendSitis.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendSitisApplication {

	@Autowired
	private UserServiceImpl userService;

	public static void main(String[] args) {
		SpringApplication.run(BackendSitisApplication.class, args);
	}
}

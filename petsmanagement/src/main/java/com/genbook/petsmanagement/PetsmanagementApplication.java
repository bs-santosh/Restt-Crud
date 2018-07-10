package com.genbook.petsmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication(scanBasePackages = {"com.genbook"})
public class PetsmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetsmanagementApplication.class, args);
	}
}

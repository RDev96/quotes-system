package com.prueba.tecnica.devintech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class DevintechApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevintechApplication.class, args);
	}

}

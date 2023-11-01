package com.migracion.hexagonal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApplicationHexagonal {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationHexagonal.class, args);
	}

}

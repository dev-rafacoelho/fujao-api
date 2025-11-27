package com.fujao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EnableAsync
public class FujaoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FujaoApiApplication.class, args);
	}

}

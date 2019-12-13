package com.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class OrderContentApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderContentApplication.class, args);
	}
}

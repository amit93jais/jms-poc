package com.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class IncomingOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(IncomingOrderApplication.class, args);
	}
}

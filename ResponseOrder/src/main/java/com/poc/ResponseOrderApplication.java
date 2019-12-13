package com.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@EnableMongoRepositories(basePackages = "com.poc.repository")
@SpringBootApplication
public class ResponseOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResponseOrderApplication.class, args);
	} 
	
}

package com.poc.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActivemqConfig {
	/*
	 * This bean configuration is required for making our bean trustable.
	 */
	@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory() {
		 ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
	      //factory.setTrustedPackages(Arrays.asList("com.poc.bean,com.poc.route".split(",")));
	      factory.setTrustAllPackages(true);
	      return factory;
	}
}

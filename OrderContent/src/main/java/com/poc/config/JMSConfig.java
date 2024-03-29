package com.poc.config;

import javax.jms.ConnectionFactory;

import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

@Configuration
@EnableJms
public class JMSConfig {

	 @SuppressWarnings("rawtypes")
	 @Bean
	    public JmsListenerContainerFactory containerFactory(ConnectionFactory connectionFactory,
	                                                        DefaultJmsListenerContainerFactoryConfigurer configurer) {
	        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
	        // This provides all boot's default to this factory
	        configurer.configure(factory, connectionFactory);
	        // You could still override some of Boot's default if necessary.
	        return factory;
	    }
	 
	 
}

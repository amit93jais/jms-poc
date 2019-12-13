package com.poc.route;

import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poc.processor.OrderProcessor;

/**
 * 
 * This class will take the bean from the queue and insert the bean into 
 * mongdb.
 * 
 * Note:If we want to process our bean into db through route builder,
 * comment the listener class in the project.because listener and route builder
 * both are doing the same task.
 */

@Component
public class OrderProcessorRouteBuilder extends RouteBuilder {

	static final Logger log = LoggerFactory.getLogger(OrderProcessor.class);
	
	@Autowired
	private Processor orderProcessor;

	@Override
	public void configure() throws Exception {
		from("jms:queue:order-queue").process(orderProcessor);
		log.info("Order Successfully saved in db..");

	}

}

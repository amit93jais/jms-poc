package com.poc.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poc.bean.Part;
import com.poc.repository.OrderRepository;

/**
 * 
 * @author amitjaiswal
 *
 *This is processor for OrderProcessorRouteBuilder.This processor class will de-serialize
 * the bean coming from queue.
 */

@Component
public class OrderProcessor implements Processor {

 static final Logger log = LoggerFactory.getLogger(OrderProcessor.class);
 
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void process(Exchange exchange) {
		Part part = null;
		try {
			part = exchange.getIn().getBody(Part.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("order processiong", part);
		orderRepository.save(part);
	}

}

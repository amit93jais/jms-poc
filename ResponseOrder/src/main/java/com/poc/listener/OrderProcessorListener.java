package com.poc.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.poc.bean.Part;
import com.poc.processor.OrderProcessor;
import com.poc.repository.OrderRepository;


/* * This class will take the bean from the queue and insert the bean into 
 * mongdb.
 * 
 * Note:If we want to process our bean into db through listener
 *      comment the route class in the project.because listener and router
 *      both are doing the same task.*/
 
@Component
public class OrderProcessorListener {
	static final Logger log = LoggerFactory.getLogger(OrderProcessor.class);
	
	  @Autowired
	  private OrderRepository orderRepository;
	  
	  @JmsListener(destination = "order-queue", containerFactory = "myFactory")
	  public void receiveMessage( Message<Part> message) {
		  Part part = message.getPayload();
	      log.info("Received <" + part + ">");
	      orderRepository.save(part);
	  }
}

package com.poc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poc.bean.Part;
import com.poc.services.MessageSenderService;

/**
 * 
 * @author amitjaiswal
 *
 */

@RestController
@RequestMapping(value = "/placeOrder")
public class IncominOrderController {
	
	static final Logger log = LoggerFactory.getLogger(IncominOrderController.class);

	@Autowired
	private MessageSenderService messageSenderServiceImpl;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void tested() {
		System.out.println("Tested");
	}
	
	/**
	 * 
	 * This method will accept the order for http endpoint in xml format and process the request.
	 */
	@RequestMapping(value = "/xml", method = RequestMethod.POST)//order
	public void placeOrderForHTTP(@RequestBody List<Part> parts) {//take as a json instead of bean
		log.info("Order reuested from http end point", parts );
		parts.forEach(( part ) ->  messageSenderServiceImpl.sendXmlOrder( part ));
	}

}

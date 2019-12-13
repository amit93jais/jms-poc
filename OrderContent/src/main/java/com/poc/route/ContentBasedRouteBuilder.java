package com.poc.route;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jacksonxml.JacksonXMLDataFormat;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poc.bean.Part;
import com.poc.services.MessageSenderService;

@Component
public class ContentBasedRouteBuilder extends RouteBuilder {

	static final Logger log = LoggerFactory.getLogger(ContentBasedRouteBuilder.class);
	
	@Autowired
	private MessageSenderService messageSenderServiceImpl;

	@SuppressWarnings("unchecked")
	@Override
	public void configure() throws Exception {

		JacksonXMLDataFormat format = new JacksonXMLDataFormat();
		format.useList();
		format.setUnmarshalType(Part.class);

		final DataFormat csvBindy = new BindyCsvDataFormat(Part.class);

		from("jms:queue:incoming-order-queue").choice()//from properties file
		
				.when(header(Exchange.CONTENT_TYPE).isEqualTo("xml")).unmarshal(format).process(exchange -> {
					List<Part> parts = (List<Part>) exchange.getIn().getBody();
					parts.forEach((part) ->{
					  log.info("Order bean for xml content type", part );	
					  messageSenderServiceImpl.sendMessage( part );
					});
				})

				.when(header(Exchange.CONTENT_TYPE).isEqualTo("csv")).unmarshal(csvBindy).process(exchange -> {
					List<Part> parts = (List<Part>) exchange.getIn().getBody();
					parts.forEach((part) -> messageSenderServiceImpl.sendMessage(part));
				})

				.otherwise().process(exchange -> {
					Part part = exchange.getIn().getBody(Part.class);
					messageSenderServiceImpl.sendMessage( part );
				});
				
			//.to("jms:queue:order-queue").end();

	}
}

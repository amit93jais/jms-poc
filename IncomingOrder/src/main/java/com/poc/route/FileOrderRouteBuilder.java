package com.poc.route;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.poc.utils.Constants;
/**
 * 
 * @author amitjaiswal
 *
 */
@Component
public class FileOrderRouteBuilder extends RouteBuilder {
	
	static final Logger log = LoggerFactory.getLogger(FileOrderRouteBuilder.class);

	@Override
	public void configure() throws Exception {
		
		from("{{fromFile}}").convertBodyTo(java.lang.String.class).process(exchange -> {

			String ext = FilenameUtils.getExtension((String) exchange.getIn().getHeader(Exchange.FILE_NAME));
			
			if (ext.equals( Constants.XML )) {
				log.info( "Xml order coming from FTP end point:", exchange.getIn().getBody() );
				exchange.getOut().setBody(exchange.getIn().getBody());
				exchange.getOut().setHeader(exchange.CONTENT_TYPE, Constants.XML );

			} else if (ext.equals( Constants.CSV )) {
				log.info( "csv order coming from FTP end point:", exchange.getIn().getBody() );//coommon
				exchange.getOut().setBody(exchange.getIn().getBody());
				exchange.getOut().setHeader(exchange.CONTENT_TYPE, Constants.CSV );
			}
		})
		.to("jms:queue:incoming-order-queue"); //tofile
	}

}

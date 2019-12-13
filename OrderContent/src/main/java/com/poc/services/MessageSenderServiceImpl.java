package com.poc.services;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.poc.bean.Part;

@Component
public class MessageSenderServiceImpl implements MessageSenderService{

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Override
	public void sendMessage( final Part part ) {
		 jmsTemplate.send( "order-queue", new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				ObjectMessage object = session.createObjectMessage( part );
				return object;
			}
		});
	 }
}

package com.poc.services;

import com.poc.bean.Part;

/**
 * 
 * @author amitjaiswal
 *
 */
public interface MessageSenderService {
	
  public void sendXmlOrder( Part part );
  
}

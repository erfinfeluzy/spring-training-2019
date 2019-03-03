package com.erfinfeluzy.training.spring.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.erfinfeluzy.training.spring.model.Email;

@Component
public class Sender {

	private static final String QUEUE_DESTINATION = "mailbox.queue";
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	public void sendMessage() {
		jmsTemplate.convertAndSend(QUEUE_DESTINATION, new Email("admin@localhost", "Connection test!"));
	}
}

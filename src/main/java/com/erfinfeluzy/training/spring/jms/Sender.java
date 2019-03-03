package com.erfinfeluzy.training.spring.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import com.erfinfeluzy.training.spring.model.Email;

@Component
public class Sender {

	private static final String MAILBOX_QUEUE_DESTINATION = "mailbox.queue";
	private static final String TEST_QUEUE_DESTINATION = "test.queue";
	
	@Autowired
	@Qualifier("jacksonMessageConverter")
	private MessageConverter jacksonMessageConverter;
	
	@Autowired
	@Qualifier("simpleMessageConverter")
	private MessageConverter simpleMessageConverter;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	public void sendEmailMessage() {
		jmsTemplate.setMessageConverter(jacksonMessageConverter);
		jmsTemplate.convertAndSend(MAILBOX_QUEUE_DESTINATION, 
				new Email("admin@localhost", "Connection test!"));
	}
	
	public void sendTextMessage() {
		jmsTemplate.setMessageConverter(simpleMessageConverter);
		jmsTemplate.convertAndSend(TEST_QUEUE_DESTINATION, 
				"Test kirim pesan!");
	}
}

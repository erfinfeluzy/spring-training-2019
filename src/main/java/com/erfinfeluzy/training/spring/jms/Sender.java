package com.erfinfeluzy.training.spring.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import com.erfinfeluzy.training.spring.model.Email;

@Component
public class Sender {

	private static final String MAILBOX_QUEUE_DESTINATION = "mailbox.queue";
	private static final String TEXT_QUEUE_DESTINATION = "text.queue";
	
	private static final String ALERT_TOPIC_DESTINATION = "alert.topic";
	
	
	@Autowired
	@Qualifier("jacksonMessageConverter")
	private MessageConverter jacksonMessageConverter;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	
	/** Queue **/
	
	public void sendTextMessage() {
		jmsTemplate.convertAndSend(TEXT_QUEUE_DESTINATION, 
				"Test kirim pesan!");
	}
	
	public void sendEmailMessage() {
		jmsTemplate.setMessageConverter(jacksonMessageConverter);
		jmsTemplate.convertAndSend(MAILBOX_QUEUE_DESTINATION, 
				new Email("admin@localhost", "Connection test!"));
	}
	
	
	/** Topic **/
	
	public void sendAlertMessage() {
		jmsTemplate.convertAndSend(ALERT_TOPIC_DESTINATION, 
				"System alert!");
	}
	
}

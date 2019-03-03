package com.erfinfeluzy.training.spring.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.erfinfeluzy.training.spring.model.Email;

@Component
public class Receiver {

	private static final String MAILBOX_QUEUE_DESTINATION = "mailbox.queue";
	private static final String TEST_QUEUE_DESTINATION = "test.queue";
	
	@JmsListener(destination = MAILBOX_QUEUE_DESTINATION)
    public void receiveEmailMessage(Email email) {
        System.out.println("Received <" + email + ">");
    }
	
	@JmsListener(destination = TEST_QUEUE_DESTINATION)
	public void receiveTextMessage(String message) {
		System.out.println("Received <" + message + ">");
	}
}

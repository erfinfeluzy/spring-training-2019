package com.erfinfeluzy.training.spring.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.erfinfeluzy.training.spring.model.Email;

@Component
public class Receiver {

	private static final String QUEUE_DESTINATION = "mailbox.queue";
	
	@JmsListener(destination = QUEUE_DESTINATION)
    public void receiveMessage(Email email) {
        System.out.println("Received <" + email + ">");
    }
}

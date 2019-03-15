package com.erfinfeluzy.training.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erfinfeluzy.training.spring.jms.Sender;

@RestController
@RequestMapping("/api")
public class TestJmsRestController {

	@Autowired
	private Sender sender;
	
	/** Queue **/
	
	@GetMapping("/textjms")
	public ResponseEntity<?> testTextJmsService() {
		sender.sendTextMessage();
		return ResponseEntity.ok().body("Text message has been send!");
	}
	
	@GetMapping("/mailjms")
	public ResponseEntity<?> testEmailJmsService() {
		sender.sendEmailMessage();
		return ResponseEntity.ok().body("Email message has been send!");
	}
	
	/** Topic **/
	
	@GetMapping("/alertjms")
	public ResponseEntity<?> testAlertJmsService() {
		sender.sendAlertMessage();
		return ResponseEntity.ok().body("Alert message has been send!");
	}
	
}

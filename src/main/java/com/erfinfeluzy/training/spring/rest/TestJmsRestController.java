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
	
	@GetMapping("/testjms")
	public ResponseEntity<?> testJmsService() {
		sender.sendMessage();
		return ResponseEntity.ok().body("message has been send!");
	}
}

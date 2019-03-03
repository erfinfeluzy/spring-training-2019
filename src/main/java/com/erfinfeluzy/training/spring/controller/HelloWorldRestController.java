package com.erfinfeluzy.training.spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
@RequestMapping("/api")
public class HelloWorldRestController {
	
	/** Serve as {@link #getHelloWorld()} which constructed as REST producer. */
	@GetMapping(value = "/hello")
	public ResponseEntity<?> getHelloWorld() {
		
		Hello hello = new Hello();
		hello.setStatus("success");
		hello.setMessage("Hello World!");
		
		return ResponseEntity.ok().body(hello);
	}
	
	// define inner class which used specifically by this controller
	@Data
	private class Hello {
		private String status;
		private String message;
	}
}

package com.erfinfeluzy.training.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.Data;

@RestController
@RequestMapping("/api")
public class PingRestController {

	private static final String ENDPOINT_URL = "http://localhost:8080/api/hello";
	
	@Autowired
	private RestTemplate restTemplate;
	
	/** Serve as {@link #pingHelloWorldRestController()} which constructed as REST consumer. */
	@GetMapping(value = "/ping")
	public ResponseEntity<?> pingHelloWorldRestController() {
		
		ResponseEntity<String> response = restTemplate
				.exchange(ENDPOINT_URL, HttpMethod.GET, null, String.class);
		
		// if succeed will construct special body message
		if (HttpStatus.OK.equals(response.getStatusCode())) {
			Ping ping = new Ping();
			ping.setStatus("success");
			ping.setMessage("Pong!");
			
			return ResponseEntity.ok().body(ping);
		}
		
		// if failed will return the response from producer as is
		return response;
	}
	
	// define inner class which used specifically by this controller
	@Data
	private class Ping {
		private String status;
		private String message;
	}
}

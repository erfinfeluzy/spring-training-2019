package com.erfinfeluzy.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication(scanBasePackages = { "com.erfinfeluzy" })
@PropertySource({
	"classpath:apps.properties"	
})
public class Application {

	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
	}

}



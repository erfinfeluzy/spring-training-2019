package com.erfinfeluzy.training.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.erfinfeluzy.training.spring")
public class DatabaseConfig {

}

package com.zemoso.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
public class SpringKafkaTemplateApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaTemplateApplication.class, args);
	}
}

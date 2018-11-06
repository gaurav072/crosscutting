package com.startwithjava.crosscutting;

import com.startwithjava.crosscutting.logging.filter.ExternalRequestInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@SpringBootApplication
public class CentralLogApplication {
	public static void main(String[] args) {
		SpringApplication.run(CrosscuttingApplication.class, args);
	}
}

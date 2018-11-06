package com.startwithjava.crosscutting.logging.config;

import com.startwithjava.crosscutting.logging.filter.ExternalRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Configuration
public class CentralLogConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate() {
            {
                setInterceptors(Collections.singletonList(new ExternalRequestInterceptor()));
            }
        };
    }
}

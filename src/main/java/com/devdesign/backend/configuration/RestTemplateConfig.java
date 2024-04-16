package com.devdesign.backend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        // Customize your RestTemplate here (e.g., add interceptors, timeouts)
        return new RestTemplate();
    }
}


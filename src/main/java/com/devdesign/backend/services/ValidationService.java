package com.devdesign.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;



@Service
public class ValidationService {


    @Autowired
    public ValidationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    private final RestTemplate restTemplate;

    public Boolean validate(String token) {
        String url = "http://20.15.114.131:8080/api/login";

        // Create request headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create request body
        String requestBody = "{\"apiKey\": \"" + token + "\"}";

        // Create HTTP entity with headers and body
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        // Send POST request and retrieve response
        try {
            // Send POST request and retrieve response
            String response = restTemplate.postForObject(url, requestEntity, String.class);

            // Parse the response JSON (assuming it contains a field named "deliverable")
            // ...

            // Return the response
            return true;
        } catch (HttpClientErrorException.Unauthorized unauthorizedException) {
            // Handle unauthorized exception
            return false; // Return a specific value to indicate failure
        }
    }

}

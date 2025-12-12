package com.example.assistente.service;

import com.example.assistente.dto.groq.GroqRequest;
import com.example.assistente.dto.groq.GroqResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TutorService {

    @Value("${groq.api.key}")
    private String apiKey;

    @Value("${groq.model}")
    private String model;

    private final String URL = "https://api.groq.com/openai/v1/chat/completions";

    private final RestTemplate restTemplate = new RestTemplate();

    public String ask(String question) {

        GroqRequest req = new GroqRequest(model, question);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        HttpEntity<GroqRequest> entity = new HttpEntity<>(req, headers);

        ResponseEntity<GroqResponse> response =
                restTemplate.exchange(URL, HttpMethod.POST, entity, GroqResponse.class);

        return response.getBody().getFirstAnswer();
    }
}

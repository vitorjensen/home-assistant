package com.example.assistente.dto.groq;

import lombok.Data;
import java.util.List;

@Data
public class GroqRequest {

    private String model;
    private List<Message> messages;

    public GroqRequest(String model, String question) {
        this.model = model;
        this.messages = List.of(
                new Message("user", question)
        );
    }

    @Data
    public static class Message {
        private String role;
        private String content;

        public Message(String role, String content) {
            this.role = role;
            this.content = content;
        }
    }
}

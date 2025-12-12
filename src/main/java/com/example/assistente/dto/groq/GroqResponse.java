package com.example.assistente.dto.groq;

import lombok.Data;
import java.util.List;

@Data
public class GroqResponse {
    private List<Choice> choices;

    @Data
    public static class Choice {
        private Message message;
    }

    @Data
    public static class Message {
        private String role;
        private String content;
    }

    public String getFirstAnswer() {
        if (choices == null || choices.isEmpty()) return "";
        return choices.get(0).getMessage().getContent();
    }
}

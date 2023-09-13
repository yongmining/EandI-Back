package com.sound.kiosk.chatGPT;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ChatGptService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final WebClient webClient;

    private final ObjectMapper objectMapper;

    private final String openaiApiKey;

    public ChatGptService(WebClient.Builder webClientBuilder, ObjectMapper objectMapper,
                      @Value("${chat.openai-api-key}") String openaiApiKey) {
        this.webClient = webClientBuilder.baseUrl("https://api.openai.com").build();
        this.objectMapper = objectMapper;
        this.openaiApiKey = openaiApiKey;
    }

    public String completeChat(String prompt) {

        List<ChatGptRequest.Message> messages = new ArrayList<>();
        messages.add(new ChatGptRequest.Message("user", prompt));
        ChatGptRequest request = new ChatGptRequest(
                "gpt-3.5-turbo-0301",
                0.9,
                messages
        );
        try {
            ChatGptResponse response = webClient.post()
                    .uri("/v1/chat/completions")
                    .header("Authorization", "Bearer " + openaiApiKey)
                    .bodyValue(request)
                    .retrieve()
                    .bodyToMono(ChatGptResponse.class)
                    .blockOptional()
                    .orElseThrow(() -> new IllegalStateException("Error occurred while completing chat"));

            if (response.choices != null && !response.choices.isEmpty()) {
                ChatGptResponse.Choice firstChoice = response.choices.get(0);
                if (firstChoice.message != null) {
                    return firstChoice.message.content;
                }
            }
            // 대화 메시지를 가져오지 못한 경우 처리
            throw new IllegalStateException("Unable to retrieve chat response.");
        } catch (WebClientResponseException e) {
            log.error("Error occurred while completing chat - " + e.getResponseBodyAsString(), e);
            throw new IllegalStateException("Error occurred while completing chat", e);
        }
    }
}

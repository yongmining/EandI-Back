package com.sound.kiosk.whisper;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WhisperService {

    private final WebClient webClient;

    @Value("${whisper.api.key}")
    private String apiKey;
    

    public WhisperService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.openai.com/v1/").build();
    }

    public Mono<WhisperResponse> completeChat(String prompt) {
        return webClient.post()
            .uri("chat/completions")
            .header("Authorization", "Bearer " + apiKey)
            .bodyValue(new WhisperRequest(prompt))
            .retrieve()
            .bodyToMono(WhisperResponse.class);
    }

    public Mono<WhisperResponse> completeChatWithAudio(MultipartFile audioFile, String prompt) throws IOException {
        ByteArrayResource resource = new ByteArrayResource(audioFile.getBytes()) {
            @Override
            public String getFilename() {
                return audioFile.getOriginalFilename(); // 원본 파일 이름을 반환
            }
        };

        MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
        parts.add("file", resource);

        return webClient.post()
            .uri("chat/completions")
            .header("Authorization", "Bearer " + apiKey)
            .body(BodyInserters.fromMultipartData("file", parts))
            .retrieve()
            .bodyToMono(WhisperResponse.class);
    }

}

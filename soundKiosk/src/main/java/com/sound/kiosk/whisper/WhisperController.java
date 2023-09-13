package com.sound.kiosk.whisper;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/whisper")
public class WhisperController {

    private final WhisperService whisperService;

    @Autowired
    public WhisperController(WhisperService whisperService) {
        this.whisperService = whisperService;
    }

    @PostMapping("/complete")
    public Mono<WhisperResponse> completeChat(
        @RequestPart("audioFile") MultipartFile audioFile,
        @RequestPart("prompt") String prompt
    ) {
        try {
            // WhisperService를 사용하여 오디오 파일을 변환하고 Whisper API와 통신
            return whisperService.completeChatWithAudio(audioFile, prompt);
        } catch (IOException e) {
            // IOException 처리 코드 작성
            e.printStackTrace(); // 예외 처리 방법에 따라 적절한 로깅 또는 예외 처리를 수행
            // 예외 처리 후 반환할 값 또는 오류 응답을 정의할 필요가 있습니다.
            // 이 예제에서는 Mono.error() 등을 사용하여 오류 응답을 생성할 수 있습니다.
            return Mono.error(e);
        }
    }
}



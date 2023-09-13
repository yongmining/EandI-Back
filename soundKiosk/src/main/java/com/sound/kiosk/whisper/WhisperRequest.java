package com.sound.kiosk.whisper;

public class WhisperRequest {

    private String prompt;

    // 기본 생성자
    public WhisperRequest() {
    }

    // 인수가 하나인 생성자
    public WhisperRequest(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
}

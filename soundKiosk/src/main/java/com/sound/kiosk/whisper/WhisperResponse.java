package com.sound.kiosk.whisper;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WhisperResponse {
	 private String id;
	 private String object;
	 private long created;
	 private String model;

	 @JsonProperty("usage")
	 private UsageInfo usageInfo;

	 private List<ChatChoice> choices;

	 // Getter and Setter methods for the fields above

	 public static class UsageInfo {
	     @JsonProperty("prompt_tokens")
	     private int promptTokens;
	        
	     @JsonProperty("completion_tokens")
	      private int completionTokens;

	      @JsonProperty("total_tokens")
	      private int totalTokens;

	      // Getter methods for the fields above
	 }

	 public static class ChatChoice {
	      private ChatMessage message;
	      private String finishReason;
	      private int index;

	        // Getter methods for the fields above
	 }

	 public static class ChatMessage {
	      private String role;
	      private String content;

	      // Getter methods for the fields above
	 }
}


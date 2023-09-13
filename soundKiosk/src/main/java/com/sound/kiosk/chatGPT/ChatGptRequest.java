package com.sound.kiosk.chatGPT;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class) 
@AllArgsConstructor 
@NoArgsConstructor 
@Setter
public class ChatGptRequest {

        public String model;
        public List<Message> messages;
        public double temperature;
        
        public ChatGptRequest(String a, double b,  List<ChatGptRequest.Message> c) {
        	
			// TODO Auto-generated constructor stub
		}
       
        @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class) 
        @AllArgsConstructor 
        @NoArgsConstructor
        public static class Message {
            public String role;
            public String content;

            // 명시적으로 기본 생성자 추가
            public Message(String message, String message2) {
            }
        }
}
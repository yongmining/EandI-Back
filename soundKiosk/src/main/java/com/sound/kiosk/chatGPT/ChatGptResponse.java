package com.sound.kiosk.chatGPT;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.sound.kiosk.chatGPT.ChatGptRequest.Message;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import lombok.Getter;
import lombok.Setter;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Getter
public class ChatGptResponse {
        public String id;
        public String object;
        public long created;
        public String model;
        public ChatGptResponse.Usage usage;
        public List<ChatGptResponse.Choice> choices;
        

        @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)  
		@Getter
        public static class Usage {
            public int promptTokens;
            public int completionTokens;
            public int totalTokens;
        }

        @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class) 
		@Getter
        public static class Choice {
            public ChatGptResponse.Choice.Message message;
            public String finishReason;
            public int index;

            @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class) 
			@Getter 
			@Setter
            public static class Message {
                public String role;
                public String content;
            }
        }
        
}
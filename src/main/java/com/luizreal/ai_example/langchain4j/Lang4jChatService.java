package com.luizreal.ai_example.langchain4j;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Lang4jChatService {
    private final ChatModel model;

    public Lang4jChatService(
            @Value("${spring.ai.ollama.base-url:http://localhost:11434}") String baseUrl,
            @Value("${spring.ai.ollama.chat.model:qwen2.5:3b}") String modelName
    ) {
        this.model = OllamaChatModel.builder()
                .baseUrl(baseUrl)
                .modelName(modelName)
                .build();
    }

    public String run(String userPrompt) {
        return model.chat(userPrompt);
    }
}

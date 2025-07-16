package com.example.springollamaai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.Map;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final ChatClient chatClient;
    private final ChatModel chatModel;

    public ChatController(ChatModel chatModel) {
        this.chatClient = ChatClient.builder(chatModel).build();
        this.chatModel = chatModel;
    }

    @PostMapping(consumes = "text/plain", produces = "text/plain")
    public String chat(@RequestBody String message) {
        return chatClient.prompt().user(message).call().content();
    }

    @GetMapping("/ai/generate")
    public Map<String, String> generate(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        return Map.of("generation", chatModel.call(message));
    }

    @GetMapping("/ai/generateStream")
    public Flux<ChatResponse> generateStream(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        return chatModel.stream(new Prompt(new UserMessage(message)));
    }

    @PostMapping("/withOptions")
    public String chatWithOptions(@RequestBody String message,
                                 @RequestParam(value = "temperature", defaultValue = "0.7") double temperature,
                                 @RequestParam(value = "model", defaultValue = "llama3.2:latest") String model) {
        return chatModel.call(new Prompt(message, OllamaOptions.builder().model(model).temperature(temperature).build()))
                .getResult().getOutput().getText();
    }

    @PostMapping("/creative")
    public String creativeChat(@RequestBody String message) {
        return chatClient.prompt().user(message)
                .options(OllamaOptions.builder().temperature(0.9).topK(50).topP(0.95).build())
                .call().content();
    }

    @PostMapping("/focused")
    public String focusedChat(@RequestBody String message) {
        return chatClient.prompt().user(message)
                .options(OllamaOptions.builder().temperature(0.2).topK(10).topP(0.5).build())
                .call().content();
    }
}

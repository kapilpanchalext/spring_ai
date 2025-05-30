package com.java.ollama.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
public class ChatController {
	private final ChatClient chatClient;
	
	public ChatController(ChatClient.Builder chatClient) {
    this.chatClient = chatClient.build();
	}

	@GetMapping(path = "/joke")
	public ResponseEntity<String> joke(){

		String joke = chatClient
											.prompt()
											.user("Please tell me a Dad joke about computers")
											.call()
											.content();

		return ResponseEntity
							.status(HttpStatus.OK)
							.body(joke);
	}
}

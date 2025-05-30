package com.java.ai.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.java.ai.service.GeminiService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/gemini")
@RequiredArgsConstructor
public class GeminiController {

	private final GeminiService geminiService;
	
	@GetMapping(path = "/joke")
	public ResponseEntity<String> getDadJoke(){
		return ResponseEntity.status(HttpStatus.OK).body(geminiService.getDataJoke());
	}
}

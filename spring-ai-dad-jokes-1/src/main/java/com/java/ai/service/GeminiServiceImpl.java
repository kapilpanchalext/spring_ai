package com.java.ai.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GeminiServiceImpl implements GeminiService {

	private final RestTemplate restTemplate;
	
	@Value("${google.api.key}")
	private String apiKey;

	@Override
	public String getDataJoke() {
		String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-pro:generateContent?key="
				+ apiKey;

		Map<String, Object> requestBody = Map.of("contents",
				List.of(Map.of("parts", List.of(Map.of("text", "Tell me a Data Joke about Computers?")))));

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);

		ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

		return response.getBody();
	}
}

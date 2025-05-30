package com.java.ollama;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.java.ollama.functions.WeatherConfigProperties;

@SpringBootApplication
@EnableConfigurationProperties(WeatherConfigProperties.class)
public class SpringAiOllama2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringAiOllama2Application.class, args);
	}

}

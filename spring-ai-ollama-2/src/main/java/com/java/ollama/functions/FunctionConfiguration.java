package com.java.ollama.functions;

import java.util.function.Function;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

@Configuration
public class FunctionConfiguration {
	private final WeatherConfigProperties props;

  public FunctionConfiguration(WeatherConfigProperties props) {
      this.props = props;
  }

  @Bean
  @Description("Get the current weather conditions for the given city.")
  Function<WeatherService.Request, WeatherService.Response> currentWeatherFunction() {
      return new WeatherService(props);
  }

}

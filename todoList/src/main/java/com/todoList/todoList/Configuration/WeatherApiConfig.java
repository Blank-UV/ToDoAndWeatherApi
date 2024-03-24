package com.todoList.todoList.Configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "weather.api")
@Data
public class WeatherApiConfig {
    private String apiKey;
    private String apiUrl;

    // getters and setters
}

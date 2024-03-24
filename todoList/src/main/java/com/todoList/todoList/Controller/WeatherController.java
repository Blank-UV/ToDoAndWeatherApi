package com.todoList.todoList.Controller;

import com.todoList.todoList.Service.WeatherService;
import com.todoList.todoList.dto.WeatherData;
import com.todoList.todoList.model.WeatherDataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather")
    public WeatherData getWeather(@RequestParam String city) {

        return weatherService.getWeather(city);
    }
    @GetMapping("/weather/db")
    public List<WeatherDataEntity> getAllWeatherFromDB() {
        return weatherService.getAllWeather();
    }
}

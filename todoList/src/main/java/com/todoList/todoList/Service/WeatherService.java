package com.todoList.todoList.Service;

import com.todoList.todoList.Configuration.WeatherApiConfig;
import com.todoList.todoList.Repository.WeatherDataRepository;
import com.todoList.todoList.dto.WeatherData;
import com.todoList.todoList.model.WeatherDataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class WeatherService {

    @Autowired
    private WeatherApiConfig config;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private WeatherDataRepository weatherDataRepository;

    public void saveWeatherData(WeatherDataEntity weatherData) {
        weatherDataRepository.save(weatherData);
    }
    public WeatherData getWeather(String city) {
        String url = String.format("%s?q=%s&appid=%s", config.getApiUrl(), city, config.getApiKey());
        WeatherData weatherData = restTemplate.getForObject(url, WeatherData.class);
        WeatherDataEntity weatherDataEntity = new WeatherDataEntity();
        weatherDataEntity.setCity(city);
        if(weatherData != null) {
            weatherDataEntity.setTemperature(weatherData.getTemp());
            saveWeatherData(weatherDataEntity);
            return weatherData;
        }
        return null;
    }

    @Scheduled(fixedDelay = 30000) // Run every 30sec (in milliseconds)
    public void refreshWeatherData() {
        List<WeatherDataEntity> weatherDataEntityList = getAllWeather();
        weatherDataEntityList.forEach(weatherDataEntity -> {
            Logger.getLogger("WeatherService").log(Level.INFO,"Refreshing weather data for city" + weatherDataEntity.getCity());
            getWeather(weatherDataEntity.getCity());
        });
    }

    public List<WeatherDataEntity> getAllWeather() {
        return weatherDataRepository.findAll();
    }


}

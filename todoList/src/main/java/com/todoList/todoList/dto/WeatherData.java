package com.todoList.todoList.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class WeatherData {
    private Coord coord;
    private Main main;
    // other fields as needed

    // getters and setters

    public double getTemp() {
        return main.getTemp();
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
class Main {
    private double temp;
    // other fields as needed

    // getters and setters
}

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
class Coord {
    private double lon;
    private double lat;
    // other fields as needed

    // getters and setters
}

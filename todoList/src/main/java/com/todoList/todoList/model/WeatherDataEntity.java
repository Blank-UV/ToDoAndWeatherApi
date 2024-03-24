package com.todoList.todoList.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class WeatherDataEntity {
    @Id
    private String city;
    private double temperature;
    // other fields as needed

    // getters and setters
}

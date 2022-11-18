package com.example.weatherapispring;

import com.example.weatherapispring.controller.AccuWeatherController;
import com.example.weatherapispring.model.entity.City;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class WeatherApiSpringApplication implements CommandLineRunner {

    private final AccuWeatherController accuWeatherController;

    public static void main(String[] args) {
        SpringApplication.run(WeatherApiSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<City> topCities =
                accuWeatherController.getTopCities(
                        "XW2mt2o1U45ZJZyCRDm9wZ6IEO8dDWTH",
                        50);
        System.out.println(topCities);
    }
}

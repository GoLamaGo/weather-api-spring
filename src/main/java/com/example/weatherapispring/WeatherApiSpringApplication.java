package com.example.weatherapispring;

import com.example.weatherapispring.controller.AccuWeatherController;
import com.example.weatherapispring.model.entity.City;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class WeatherApiSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherApiSpringApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner1(AccuWeatherController accuWeatherController) {
        return args -> {
//            List<City> topCities = accuWeatherController.getTopCities(
//                    "XW2mt2o1U45ZJZyCRDm9wZ6IEO8dDWTH",
//                    50);
//            System.out.println(topCities);
        };
    }

}

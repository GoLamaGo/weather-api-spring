package com.example.weatherapispring.controller;

import com.example.weatherapispring.model.entity.City;
import com.example.weatherapispring.service.AccuWeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/accuWeather")
public class AccuWeatherController {

    private final AccuWeatherService accuWeatherService;

    @GetMapping(path = "/{cityCount}")
    public List<City> getTopCities(@RequestParam String apikey, @PathVariable int cityCount) {
        return accuWeatherService.getTopCities(apikey, cityCount);
    }

}

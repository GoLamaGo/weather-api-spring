package com.example.weatherapispring.controller;

import com.example.weatherapispring.model.api.aqqu.currentcondition.CurrentConditionRs;
import com.example.weatherapispring.model.entity.City;
import com.example.weatherapispring.model.entity.CurrentCondition;
import com.example.weatherapispring.service.AccuWeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/accuWeather")
public class AccuWeatherController {

    private final AccuWeatherService accuWeatherService;

    @GetMapping(path = "/topcities/{cityCount}")
    public List<City> getTopCities(@RequestParam String apikey, @PathVariable int cityCount) {
        return accuWeatherService.getTopCities(apikey, cityCount);
    }
    @GetMapping(path = "/currentconditions/{locationKey}")
    public List<CurrentCondition> getCurrentConditions(@RequestParam String apikey,
                                                       @PathVariable int locationKey) {
        return accuWeatherService.getCurrentConditions(apikey, locationKey);
    }

}

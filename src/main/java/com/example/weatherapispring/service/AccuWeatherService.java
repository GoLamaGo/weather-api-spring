package com.example.weatherapispring.service;

import com.example.weatherapispring.client.AccuWeatherClient;
import com.example.weatherapispring.model.City;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AccuWeatherService {

    private final AccuWeatherClient accuWeatherClient;

    public List<City> getTopCities(String apikey, int cityCount) {

        return accuWeatherClient.getTopCities(apikey, cityCount);
    }

}

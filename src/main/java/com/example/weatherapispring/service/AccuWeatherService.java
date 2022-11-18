package com.example.weatherapispring.service;

import com.example.weatherapispring.client.AccuWeatherClient;
import com.example.weatherapispring.mapper.CityMapper;
import com.example.weatherapispring.model.api.aqqu.LocationCityRs;
import com.example.weatherapispring.model.entity.City;
import com.example.weatherapispring.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AccuWeatherService {
    private final CityRepository cityRepository;
    private final AccuWeatherClient accuWeatherClient;
    private final CityMapper cityMapper;

    public List<City> getTopCities(String apikey, int cityCount) {
        List<LocationCityRs> topCities = accuWeatherClient.getTopCities(apikey, cityCount);
        List<City> cityList = cityMapper.toCityList(topCities);

        cityRepository.saveAll(cityList);

        return cityList;
    }

}

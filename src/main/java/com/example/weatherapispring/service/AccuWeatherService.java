package com.example.weatherapispring.service;

import com.example.weatherapispring.client.AccuWeatherClient;
import com.example.weatherapispring.mapper.CityMapper;
import com.example.weatherapispring.mapper.CurrentConditionMapper;
import com.example.weatherapispring.model.api.aqqu.location.LocationCityRs;
import com.example.weatherapispring.model.entity.City;
import com.example.weatherapispring.model.entity.CurrentCondition;
import com.example.weatherapispring.repository.CityRepository;
import com.example.weatherapispring.repository.CurrentConditionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AccuWeatherService {
    private final CityRepository cityRepository;
    private final CurrentConditionRepository currentConditionRepository;
    private final AccuWeatherClient accuWeatherClient;
    private final CityMapper cityMapper;
    private final CurrentConditionMapper currentConditionMapper;

    public List<City> getTopCities(String apikey, int cityCount) {
        List<LocationCityRs> topCities = accuWeatherClient.getTopCities(apikey, cityCount);
        List<City> cityList = cityMapper.toCityList(topCities);

        cityRepository.saveAll(cityList);

        return cityList;
    }

    public List<CurrentCondition> getCurrentConditions(String apikey, int locationKey) {
        City city = cityRepository.findById((long) locationKey)
                .orElseThrow(() ->
                        new IllegalArgumentException("City with id " + locationKey + " not ecxist"));

        List<CurrentCondition> currentConditions = currentConditionMapper.toCurrentConditionList(
                accuWeatherClient.getCurrentConditions(apikey, locationKey));

        currentConditions.forEach(currentCondition -> currentCondition.setCity(city));

        return currentConditionRepository.saveAll(currentConditions);
    }

}

package com.example.weatherapispring.mapper;

import com.example.weatherapispring.model.api.aqqu.location.LocationCityRs;
import com.example.weatherapispring.model.entity.City;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CityMapper {

    public List<City> toCityList(List<LocationCityRs> locationCityRs) {
        return locationCityRs.stream()
                .map(this::toCity)
                .collect(Collectors.toList());
    }

    public City toCity(LocationCityRs locationCityRs) {
        return City.builder()
                .id(Long.valueOf(locationCityRs.getKey()))
                .englishName(locationCityRs.getEnglishName())
                .build();
    }
}

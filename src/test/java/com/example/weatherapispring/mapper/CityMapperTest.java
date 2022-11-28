package com.example.weatherapispring.mapper;

import com.example.weatherapispring.model.api.aqqu.location.LocationCityRs;
import com.example.weatherapispring.model.entity.City;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CityMapperTest {
    private final CityMapper cityMapper = new CityMapper();

    @Test
    void toCityList() {
        List<LocationCityRs> locationCityRs = List.of(
                locationCityRs("1"),
                locationCityRs("2")
        );

        List<City> actual = cityMapper.toCityList(locationCityRs);
    }

    @Test
    void toCity() {
    }

    private LocationCityRs locationCityRs(String key) {
        return LocationCityRs.builder()
                .englishName("1")
                .key(key)
                .build();
    }
}
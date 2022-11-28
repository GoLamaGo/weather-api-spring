package com.example.weatherapispring.service;

import com.example.weatherapispring.client.AccuWeatherClient;
import com.example.weatherapispring.mapper.CityMapper;
import com.example.weatherapispring.mapper.CurrentConditionMapper;
import com.example.weatherapispring.model.api.aqqu.location.LocationCityRs;
import com.example.weatherapispring.model.entity.City;
import com.example.weatherapispring.repository.CityRepository;
import com.example.weatherapispring.repository.CurrentConditionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest(
        classes = {
                AccuWeatherService.class,
                CityMapper.class
        },
        properties = {
                "spring.datasource.password=asdasdas"
        })
@DirtiesContext
class AccuWeatherServiceTest {

    @MockBean
    private CityRepository cityRepository;
    @MockBean
    private CurrentConditionRepository currentConditionRepository;
    @MockBean
    private AccuWeatherClient accuWeatherClient;
    @MockBean
    private CityMapper cityMapper;
    @MockBean
    private CurrentConditionMapper currentConditionMapper;

    @Autowired
    private AccuWeatherService accuWeatherService;

    @Test
    void getTopCities() {
        List<LocationCityRs> locationCityRs = List.of();

        when(accuWeatherClient.getTopCities(anyString(), anyInt()))
                .thenReturn(locationCityRs);

        List<City> cityList = List.of();
        when(cityMapper.toCityList(locationCityRs)).thenReturn(cityList);

        List<City> topCities = accuWeatherService.getTopCities("1", 50);

        assertEquals(topCities, cityList);

    }

}
package com.example.weatherapispring.client;


import com.example.weatherapispring.model.api.aqqu.currentcondition.CurrentConditionRs;
import com.example.weatherapispring.model.api.aqqu.location.LocationCityRs;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Component
public class AccuWeatherClient {

    private final RestTemplate restTemplate;

    public List<LocationCityRs> getTopCities(String apikey, int cityCount) {

        String baseUrl = "http://dataservice.accuweather.com/locations/v1/topcities/"
                + cityCount
                + "?apikey="
                + apikey;

        URI uri;
        try {
            uri = new URI(baseUrl);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Sending request: " + baseUrl);

        ResponseEntity<LocationCityRs[]> result = restTemplate.getForEntity(uri, LocationCityRs[].class);
        System.out.println("response: " + Arrays.toString(result.getBody()));

        return Arrays.asList(Objects.requireNonNull(result.getBody()));
    }

    public List<CurrentConditionRs> getCurrentConditions(String apikey, int locationKey) {
        String baseUrl = "http://dataservice.accuweather.com/currentconditions/v1/"
                + locationKey
                + "?apikey="
                + apikey;

        URI uri;
        try {
            uri = new URI(baseUrl);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Sending request: " + baseUrl);

        ResponseEntity<CurrentConditionRs[]> result =
                restTemplate.getForEntity(uri, CurrentConditionRs[].class);
        System.out.println("response: " + Arrays.toString(result.getBody()));

        return Arrays.asList(Objects.requireNonNull(result.getBody()));
    }

}

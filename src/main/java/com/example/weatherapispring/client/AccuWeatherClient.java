package com.example.weatherapispring.client;


import com.example.weatherapispring.model.City;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Component
public class AccuWeatherClient {

    private final RestTemplate restTemplate;

    public List<City> getTopCities(String apikey, int cityCount) {
        String baseUrl = "http://dataservice.accuweather.com/locations/v1/topcities/"
                + cityCount
                + "?apikey="
                + apikey;

        URI uri = null;
        try {
            uri = new URI(baseUrl);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Sending request: " + baseUrl);

        ResponseEntity<City[]> result = restTemplate.getForEntity(uri, City[].class);
        System.out.println("respinse: " + Arrays.toString(result.getBody()));

        return Arrays.asList(result.getBody());
    }

}

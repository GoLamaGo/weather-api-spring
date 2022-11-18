package com.example.weatherapispring.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class City {

    @JsonProperty("Key")
    private String key;
    @JsonProperty("EnglishName")
    private String englishName;

}

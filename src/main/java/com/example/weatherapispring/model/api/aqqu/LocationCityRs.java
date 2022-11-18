package com.example.weatherapispring.model.api.aqqu;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LocationCityRs {

    @JsonProperty("Key")
    private String key;
    @JsonProperty("EnglishName")
    private String englishName;

}

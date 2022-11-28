package com.example.weatherapispring.model.api.aqqu.location;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class LocationCityRs {

    @JsonProperty("Key")
    private String key;
    @JsonProperty("EnglishName")
    private String englishName;

}

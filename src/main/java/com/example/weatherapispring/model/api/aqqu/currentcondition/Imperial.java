package com.example.weatherapispring.model.api.aqqu.currentcondition;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Imperial {
    @JsonProperty("Value")
    public int value;
    @JsonProperty("Unit")
    public String unit;
    @JsonProperty("UnitType")
    public int unitType;
}

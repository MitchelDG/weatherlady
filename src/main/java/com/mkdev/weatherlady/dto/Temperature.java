package com.mkdev.weatherlady.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Temperature {

    @JsonProperty("Metric")
    private TemperatureValues metric;

    @JsonProperty("Imperial")
    private TemperatureValues imperial;
}

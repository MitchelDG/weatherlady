package com.mkdev.weatherlady.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class AccuweatherForecastDTO {


    @JsonProperty("Temperature")
    private Temperature temperature;
}

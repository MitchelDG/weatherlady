package com.mkdev.weatherlady.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherDTO {


    @JsonProperty("Temperature")
    private Temperature temperature;

    @JsonProperty("Wind")
    private Wind wind;

    @JsonProperty("Pressure")
    private Pressure pressure;
}


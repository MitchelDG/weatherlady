package com.mkdev.weatherlady.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CurrentDTO {


    @JsonProperty("Temperature")
    private Temperature temperature;

    @JsonProperty("Wind")
    private Wind wind;

    @JsonProperty("Pressure")
    private Pressure pressure;
}


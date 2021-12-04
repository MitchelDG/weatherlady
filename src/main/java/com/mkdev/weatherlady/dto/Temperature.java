package com.mkdev.weatherlady.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Temperature {

    @JsonProperty("Metric")
    private Values metric;

    @JsonProperty("Imperial")
    private Values imperial;
}

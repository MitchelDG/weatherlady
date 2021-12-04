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
public class Direction {

    @JsonProperty("Degrees")
    private Integer degrees;

    @JsonProperty("Localized")
    private String localized;
}

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
public class Wind {

    @JsonProperty("Direction")
    private Direction direction;

    @JsonProperty("Speed")
    private Speed speed;

}

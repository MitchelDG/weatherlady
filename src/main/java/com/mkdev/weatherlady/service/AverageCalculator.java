package com.mkdev.weatherlady.service;


import com.mkdev.weatherlady.dto.WeatherDTO;

import java.util.Arrays;

public class AverageCalculator {

    public WeatherDTO calculateAverage(WeatherDTO... conditions) {

        Integer averageValue = 0;

        for(WeatherDTO condition : conditions) {
            averageValue += condition.getValue();
        }

        WeatherDTO average = new WeatherDTO();
        average.setValue(averageValue/conditions.length);

        return average;
    }


}

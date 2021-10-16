package com.mkdev.weatherlady.service;

import com.mkdev.weatherlady.dto.*;

public class AverageCalculator {

    public CurrentDTO calculateAverage(CurrentDTO... conditions) {

        Float totalTemperature = 0F;
        Float totalPressure = 0F;
        Float totalWind = 0F;

        for (CurrentDTO condition : conditions) {
            totalTemperature += condition.getTemperature().getMetric().getValue();
            totalPressure += condition.getPressure().getMetric().getValue();
            totalWind += condition.getWind().getSpeed().getMetric().getValue();
        }


        CurrentDTO average = new CurrentDTO();

        average.builder()
                .pressure(Pressure.builder()
                        .metric(Values.builder()
                                .value(totalPressure / conditions.length)
                                .unit("mb")
                                .build())
                        .build())
                .temperature(Temperature.builder()
                        .metric(Values.builder()
                                .value(totalTemperature / conditions.length)
                                .unit("°C")
                                .build())
                        .build())
                .wind(Wind.builder()
                        .speed(Speed.builder()
                                .metric(Values.builder()
                                        .value(totalWind / conditions.length)
                                        .unit("m/s")
                                        .build())
                                .build())
                        .build());
        return average;
    }

}

package com.mkdev.weatherlady.facade;

import com.mkdev.weatherlady.dto.WeatherDTO;
import com.mkdev.weatherlady.service.AccuweatherService;
import com.mkdev.weatherlady.service.OpenWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.management.BadAttributeValueExpException;

@Component
public class WeatherFacade {

    private static final String ACCUWEATHER = "accuweather";
    private static final String OPNEWEATHER = "openweather";

    private final AccuweatherService accuweatherService;
    private final OpenWeatherService openWeatherService;


    @Autowired
    public WeatherFacade(AccuweatherService accuweatherService, OpenWeatherService openWeatherService) {
        this.accuweatherService = accuweatherService;
        this.openWeatherService = openWeatherService;
    }

    public WeatherDTO getWeather(String type, String city) throws BadAttributeValueExpException {
        if (type.equals(ACCUWEATHER)) {
            return accuweatherService.getForecastForCity(city);
        }

        else if (type.equals(OPNEWEATHER)) {
            return openWeatherService.getForecastForCity(city);
        }
        throw new BadAttributeValueExpException("BLAhLBAh");
    }

    public WeatherDTO getAverageCurrentCondition(String city) {
        //TODO: implement future / multithread
        WeatherDTO accuweatherCondition = accuweatherService.getForecastForCity(city);
        WeatherDTO openWeatherCondition = openWeatherService.getForecastForCity(city);



        return null;

    }



}

package com.mkdev.weatherlady.service;

import com.mkdev.weatherlady.dto.WeatherDTO;

public interface WeatherService {
    public WeatherDTO downloadWeather(String key);
}

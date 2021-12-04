package com.mkdev.weatherlady.service;

import com.mkdev.weatherlady.dto.CurrentDTO;

public interface WeatherService {
    public CurrentDTO downloadWeather(String key);
}

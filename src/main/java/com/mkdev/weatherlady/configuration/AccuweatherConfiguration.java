package com.mkdev.weatherlady.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@ConfigurationProperties(prefix = "app.service.accuweather")
@EnableConfigurationProperties(AccuweatherConfiguration.class)
@Data
public class AccuweatherConfiguration {

    private String searchCityUrl;
    private String currentUrl;
    private String forecastUrl;
    private String apiKey;
}

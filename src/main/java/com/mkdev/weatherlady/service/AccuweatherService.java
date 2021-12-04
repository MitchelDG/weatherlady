package com.mkdev.weatherlady.service;

import com.mkdev.weatherlady.dto.AccuweatherCitySearchResponse;
import com.mkdev.weatherlady.dto.AccuweatherForecastDTO;
import com.mkdev.weatherlady.dto.CurrentDTO;
import com.mkdev.weatherlady.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class AccuweatherService implements WeatherService {

    private final RestTemplate restTemplate;

    @Value("${app.service.accuweather.forecastUrl}")
    private String forecastUrl;

    @Value("${app.service.accuweather.searchCityUrl")
    private String searchCityUrl;

    @Value("${app.service.accuweather.apiKey")
    private String apiKey;

    public AccuweatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public CurrentDTO getForecastForCity(String city) {
        String keyByCity = this.findKeyByCity(city);

        return this.downloadWeather(keyByCity);
    }


    @Override
    public CurrentDTO downloadWeather(String key) {
        ResponseEntity<AccuweatherForecastDTO> entity = this.restTemplate.getForEntity(
                forecastUrl,
                AccuweatherForecastDTO.class
        );

        AccuweatherForecastDTO body = entity.getBody();

        return new CurrentDTO();
    }


    public String findKeyByCity(String city) {
        String uriString = UriComponentsBuilder.fromHttpUrl(this.searchCityUrl)
                .queryParam("q", city)
                .queryParam("apikey", apiKey)
                .toUriString();

        ResponseEntity<List<AccuweatherCitySearchResponse>> response = this.restTemplate.exchange(
                uriString,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );

        var cities = response.getBody();

        if (cities.isEmpty()) {
            throw new NotFoundException("");
        }

        AccuweatherCitySearchResponse accuweatherCitySearchResponse = cities.get(0);
        return accuweatherCitySearchResponse.getKey();
    }
}

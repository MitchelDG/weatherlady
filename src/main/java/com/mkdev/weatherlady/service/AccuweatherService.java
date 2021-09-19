package com.mkdev.weatherlady.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;

import com.mkdev.weatherlady.dto.AccuweatherCitySearchResponse;
import com.mkdev.weatherlady.dto.AccuweatherForecastDTO;
import com.mkdev.weatherlady.dto.WeatherDTO;

public class AccuweatherService implements WeatherService{

    private final RestTemplate restTemplate;

    @Value("${app.service.accuweather.url}")
    private String forecastUrl;

    @Value("${app.service.accuweather.searchCityUrl")
    private String searchCityUrl;

    @Value("${app.service.accuweather.apiKey")
    private String apiKey;

    public AccuweatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public WeatherDTO downloadWeather() {
        ResponseEntity<AccuweatherForecastDTO> entity =this.restTemplate.getForEntity(
                "url",
                AccuweatherForecastDTO.class
        );

        AccuweatherForecastDTO body = entity.getBody();

        return new WeatherDTO();
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
                new ParameterizedTypeReference<>() {}
        );

        var cities = response.getBody()

        if (cities.isEmpty()) {
            throw new NotFoundException;
        }
        this.restTemplate.getForEntity()
    }
}

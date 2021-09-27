package com.mkdev.weatherlady.controller;

import com.mkdev.weatherlady.dto.WeatherDTO;
import com.mkdev.weatherlady.service.AccuweatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class APIController {

    private final AccuweatherService accuweatherService;

    public APIController(AccuweatherService accuweatherService) {
        this.accuweatherService = accuweatherService;
    }

    @GetMapping(
            value = "/ping",
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public String getPing() {
        return "OK";
    }


    @GetMapping(
            value = "/weather",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<WeatherDTO> getWeather(

            @RequestParam String type,
            @RequestParam String city
    ) {

                WeatherDTO weatherDTO = accuweatherService.getForecastForCity(city);

        return ResponseEntity.ok(weatherDTO);
    }

    @GetMapping(
            value = "/openweather",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<WeatherDTO> getOpenWeather(@RequestParam String city) {


        // should point to corresponding method from openWeatherService
        WeatherDTO weatherDTO = accuweatherService.getForecastForCity(city);
        return ResponseEntity.ok(weatherDTO);
    }

}

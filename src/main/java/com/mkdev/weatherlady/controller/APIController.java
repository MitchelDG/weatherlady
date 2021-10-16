package com.mkdev.weatherlady.controller;

import com.mkdev.weatherlady.dto.CurrentDTO;
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
    public ResponseEntity<CurrentDTO> getWeather(

            @RequestParam String type,
            @RequestParam String city
    ) {

                CurrentDTO currentDTO = accuweatherService.getForecastForCity(city);

        return ResponseEntity.ok(currentDTO);
    }

    @GetMapping(
            value = "/openweather",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<CurrentDTO> getOpenWeather(
            @RequestParam String city
    ) {


        // should point to corresponding method from openWeatherService
        CurrentDTO currentDTO = accuweatherService.getForecastForCity(city);
        return ResponseEntity.ok(currentDTO);
    }

}

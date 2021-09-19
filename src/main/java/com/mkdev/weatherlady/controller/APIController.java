package com.mkdev.weatherlady.controller;

import com.mkdev.weatherlady.dto.WeatherDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class APIController {


    @GetMapping(
            value = "/ping",
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public String getPing() {
        return "OK";
    }
}

//    @GetMapping(
//            value = "/weather",
//            produces = MediaType.APPLICATION_JSON_VALUE
//    )
//    public ResponseEntity<WeatherDTO> getWeather( @RequestParam String type) {
//       return ResponseEntity<WeatherDTO>
//    }
//}

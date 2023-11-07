package com.weatherapitask.controller;

import com.weatherapitask.entity.ForecastSummary;
import com.weatherapitask.entity.HourlyForecast;
import com.weatherapitask.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("forecastSummary/{locationName}")
    public ForecastSummary getForecastSummary(@PathVariable String locationName) {
        return weatherService.getForecastSummaryByLocationName(locationName);
    }

    @GetMapping("hourlyForecast/{locationName}")
    public HourlyForecast getHourlyForecast(@PathVariable String locationName) {
        return weatherService.getHourlyForecastByLocationName(locationName);
    }
}


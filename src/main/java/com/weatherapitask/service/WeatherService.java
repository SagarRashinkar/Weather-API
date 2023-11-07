package com.weatherapitask.service;

import com.weatherapitask.entity.ForecastSummary;
import com.weatherapitask.entity.HourlyForecast;
import com.weatherapitask.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Value("${rapid.api.host}")
    private String rapidApiHost;

    @Value("${rapid.api.key}")
    private String rapidApiKey;

    @Value("${rapid.api.base.url}")
    private String baseUrl;

    private static HttpHeaders headers = null;
    private final RestTemplate restTemplate = new RestTemplate();

    public ForecastSummary getForecastSummaryByLocationName(String locationName) {
        String url = baseUrl + locationName + "/summary/";

        headers = new HttpHeaders();
        headers.set("X-RapidAPI-Host", rapidApiHost);
        headers.set("X-RapidAPI-Key", rapidApiKey);

        ResponseEntity<ForecastSummary> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), ForecastSummary.class);
        if (response.getBody() != null){
            System.out.println("response->"+response.getBody());
            return response.getBody();
        }else {
            throw new ResourceNotFoundException("Forecast", "locationName", locationName);
        }
    }

    public HourlyForecast getHourlyForecastByLocationName(String locationName) {
        String url = baseUrl + locationName + "/hourly/";

        headers = new HttpHeaders();
        headers.set("X-RapidAPI-Host", rapidApiHost);
        headers.set("X-RapidAPI-Key", rapidApiKey);

        ResponseEntity<HourlyForecast> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), HourlyForecast.class);
        if (response.getBody() != null){
            System.out.println("response->"+response.getBody());
            return response.getBody();
        }else {
            throw new ResourceNotFoundException("Forecast", "locationName", locationName);
        }
    }

}
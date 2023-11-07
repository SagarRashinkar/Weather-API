package com.weatherapitask.entity;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class HourlyForecast {

    private String locationName;
    private List<HourlyData> hourlyData;

}

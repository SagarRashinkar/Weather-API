package com.weatherapitask.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ForecastSummary {
    private String locationName;
    private String summary;
    private String temperature;
}

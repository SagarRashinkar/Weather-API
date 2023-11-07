package com.weatherapitask.entity;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class HourlyData {

    private LocalDateTime time;
    private double temperature;
    private String weatherDescription;

}

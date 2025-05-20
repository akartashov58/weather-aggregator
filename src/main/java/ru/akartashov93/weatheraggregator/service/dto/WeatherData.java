package ru.akartashov93.weatheraggregator.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * ДТО данных погоды
 */
@Getter
@Setter
@AllArgsConstructor
public class WeatherData {

    private double temperature;
    private double humidity;

}

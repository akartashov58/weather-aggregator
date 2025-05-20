package ru.akartashov93.weatheraggregator.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * ДТО усредненных данных погоды
 */
@Getter
@Setter
@AllArgsConstructor
public class AverageWeather {

    private Double averageTemperature;
    private Double averageHumidity;
}

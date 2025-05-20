package ru.akartashov93.weatheraggregator.service.integration.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * ДТО данных погоды от источника А
 */
@Getter
@Setter
public class WeatherADto {

    private Double temp;
    private Double hum;
}

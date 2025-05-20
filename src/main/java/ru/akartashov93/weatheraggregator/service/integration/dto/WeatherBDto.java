package ru.akartashov93.weatheraggregator.service.integration.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * ДТО данных погоды от источника B
 */
@Getter
@Setter
public class WeatherBDto {

    private Double temperature;
    private Double humidity;
}

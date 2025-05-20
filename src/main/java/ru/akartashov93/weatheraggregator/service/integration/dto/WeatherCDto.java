package ru.akartashov93.weatheraggregator.service.integration.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * ДТО данных погоды от источника C
 */
@Getter
@Setter
public class WeatherCDto {

    private WeatherDetail weather;

    @Getter
    @Setter
    public static class WeatherDetail {
        private Double t;
        private Double h;
    }
}

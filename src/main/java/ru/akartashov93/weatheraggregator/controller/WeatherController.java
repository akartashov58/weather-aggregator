package ru.akartashov93.weatheraggregator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.akartashov93.weatheraggregator.service.WeatherCalculationService;
import ru.akartashov93.weatheraggregator.service.dto.AverageWeather;

/**
 * Контроллер погоды
 */
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherCalculationService weatherCalculationService;

    /**
     * Получение средней величины температуры и влажности от разных источников
     * @return ДТО средней величины температуры и влажности
     */
    @GetMapping("/weather/aggregate")
    public ResponseEntity<AverageWeather> aggregateWeather() {
        return ResponseEntity.ok(weatherCalculationService.average());
    }

}

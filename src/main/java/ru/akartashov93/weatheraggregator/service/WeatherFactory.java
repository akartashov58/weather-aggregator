package ru.akartashov93.weatheraggregator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.akartashov93.weatheraggregator.service.integrator.WeatherIntegrator;
import ru.akartashov93.weatheraggregator.service.integrator.impl.WeatherIntegratorA;
import ru.akartashov93.weatheraggregator.service.integrator.impl.WeatherIntegratorB;
import ru.akartashov93.weatheraggregator.service.integrator.impl.WeatherIntegratorC;

@Component
@RequiredArgsConstructor
public class WeatherFactory {

    private final WeatherIntegratorA weatherIntegratorA;
    private final WeatherIntegratorB weatherIntegratorB;
    private final WeatherIntegratorC weatherIntegratorC;

    WeatherIntegrator getWeatherIntegrator(Integer sourceId) {
        if (sourceId <= 33) {
            return weatherIntegratorA;
        } else if (sourceId <= 66) {
            return weatherIntegratorB;
        } else {
            return weatherIntegratorC;
        }
    }

}

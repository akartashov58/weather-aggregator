package ru.akartashov93.weatheraggregator.service.integrator.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.akartashov93.weatheraggregator.service.integration.WeatherIntegrationExecutor;
import ru.akartashov93.weatheraggregator.service.integration.impl.WeatherIntegrationAService;
import ru.akartashov93.weatheraggregator.service.integrator.WeatherIntegrator;
import ru.akartashov93.weatheraggregator.service.normalizer.WeatherPayloadNormalizer;
import ru.akartashov93.weatheraggregator.service.normalizer.impl.WeatherPayloadANormalizer;

@Component
@RequiredArgsConstructor
public class WeatherIntegratorA implements WeatherIntegrator {

    private final WeatherIntegrationAService weatherIntegrationAService;
    private final WeatherPayloadANormalizer weatherPayloadANormalizer;

    @Override
    public WeatherIntegrationExecutor getExecutor() {
        return weatherIntegrationAService;
    }

    @Override
    public WeatherPayloadNormalizer getPayloadNormalizer() {
        return weatherPayloadANormalizer;
    }
}

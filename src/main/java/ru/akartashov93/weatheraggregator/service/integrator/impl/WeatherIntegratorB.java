package ru.akartashov93.weatheraggregator.service.integrator.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.akartashov93.weatheraggregator.service.integration.WeatherIntegrationExecutor;
import ru.akartashov93.weatheraggregator.service.integration.impl.WeatherIntegrationBService;
import ru.akartashov93.weatheraggregator.service.integrator.WeatherIntegrator;
import ru.akartashov93.weatheraggregator.service.normalizer.WeatherPayloadNormalizer;
import ru.akartashov93.weatheraggregator.service.normalizer.impl.WeatherPayloadBNormalizer;

@Component
@RequiredArgsConstructor
public class WeatherIntegratorB implements WeatherIntegrator {

    private final WeatherIntegrationBService weatherIntegrationBService;
    private final WeatherPayloadBNormalizer weatherPayloadBNormalizer;

    @Override
    public WeatherIntegrationExecutor getExecutor() {
        return weatherIntegrationBService;
    }

    @Override
    public WeatherPayloadNormalizer getPayloadNormalizer() {
        return weatherPayloadBNormalizer;
    }
}

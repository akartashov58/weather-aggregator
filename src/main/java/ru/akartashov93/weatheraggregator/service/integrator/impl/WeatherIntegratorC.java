package ru.akartashov93.weatheraggregator.service.integrator.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.akartashov93.weatheraggregator.service.integration.WeatherIntegrationExecutor;
import ru.akartashov93.weatheraggregator.service.integration.impl.WeatherIntegrationCService;
import ru.akartashov93.weatheraggregator.service.integrator.WeatherIntegrator;
import ru.akartashov93.weatheraggregator.service.normalizer.WeatherPayloadNormalizer;
import ru.akartashov93.weatheraggregator.service.normalizer.impl.WeatherPayloadCNormalizer;

@Component
@RequiredArgsConstructor
public class WeatherIntegratorC implements WeatherIntegrator {

    private final WeatherIntegrationCService weatherIntegrationCService;
    private final WeatherPayloadCNormalizer weatherPayloadCNormalizer;

    @Override
    public WeatherIntegrationExecutor getExecutor() {
        return weatherIntegrationCService;
    }

    @Override
    public WeatherPayloadNormalizer getPayloadNormalizer() {
        return weatherPayloadCNormalizer;
    }
}

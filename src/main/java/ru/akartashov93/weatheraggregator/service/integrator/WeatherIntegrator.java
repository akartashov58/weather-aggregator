package ru.akartashov93.weatheraggregator.service.integrator;

import ru.akartashov93.weatheraggregator.service.integration.WeatherIntegrationExecutor;
import ru.akartashov93.weatheraggregator.service.normalizer.WeatherPayloadNormalizer;

public interface WeatherIntegrator {

    WeatherIntegrationExecutor getExecutor();

    WeatherPayloadNormalizer getPayloadNormalizer();
}

package ru.akartashov93.weatheraggregator.service.integration.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.akartashov93.weatheraggregator.service.integration.WeatherIntegrationExecutor;

import java.net.URI;

/**
 * Сервис получения данных о погоде из источника A
 */
@Service
@RequiredArgsConstructor
public class WeatherIntegrationAService implements WeatherIntegrationExecutor {

    private final RestTemplate restTemplate;

    @Override
    public String getWeather() {
        return restTemplate.exchange(
                new RequestEntity<>(HttpMethod.GET, URI.create("https://localhost/integration-a/source/{id}")),
                String.class
        ).getBody();
    }

}

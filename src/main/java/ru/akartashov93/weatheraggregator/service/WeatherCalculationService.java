package ru.akartashov93.weatheraggregator.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.akartashov93.weatheraggregator.service.dto.AverageWeather;
import ru.akartashov93.weatheraggregator.service.dto.WeatherData;
import ru.akartashov93.weatheraggregator.service.integrator.WeatherIntegrator;
import ru.akartashov93.weatheraggregator.service.normalizer.WeatherPayloadNormalizer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

/**
 * Сервис расчета показателей погоды
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class WeatherCalculationService {
    private final static int THREAD_COUNT = 100;

    private final RawWeatherDataService rawWeatherDataService;
    private final NormalizedWeatherDataService normalizedWeatherDataService;

    private final WeatherFactory weatherFactory;

    /**
     * Расчет средней температуры и влажности от разных источников
     * @return ДТО средней величины температуры и влажности
     */
    public AverageWeather average() {
        List<CompletableFuture<WeatherData>> futures = new ArrayList<>();
        for (int i = 0; i < THREAD_COUNT; i++) {
            futures.add(CompletableFuture.supplyAsync(executeIntegration(i)));
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        List<Double> temps = new ArrayList<>();
        List<Double> hums = new ArrayList<>();

        futures.stream()
                .map(CompletableFuture::join)
                .forEach(weather -> {
                    temps.add(weather.getTemperature());
                    hums.add(weather.getHumidity());
                });

        double tempAverage = temps.stream()
                .filter(Objects::nonNull)
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0);
        double humidityAverage = hums.stream()
                .filter(Objects::nonNull)
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0);

        return new AverageWeather(tempAverage, humidityAverage);
    }


    private Supplier<WeatherData> executeIntegration(Integer sourceId) {
        return () -> {
            try {
                WeatherIntegrator integrator = weatherFactory.getWeatherIntegrator(sourceId);
                String payload = integrator.getExecutor().getWeather();
                rawWeatherDataService.create(sourceId, payload);
                WeatherPayloadNormalizer normalizer = integrator.getPayloadNormalizer();
                WeatherData data = normalizer.normalize(payload);
                normalizedWeatherDataService.create(sourceId, data);
                return data;
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
            return null;
        };
    }

}

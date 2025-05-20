package ru.akartashov93.weatheraggregator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.akartashov93.weatheraggregator.model.NormalizedWeatherData;
import ru.akartashov93.weatheraggregator.repository.NormalizedWeatherDataRepository;
import ru.akartashov93.weatheraggregator.service.dto.WeatherData;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class NormalizedWeatherDataService {

    private final NormalizedWeatherDataRepository normalizedWeatherDataRepository;

    public void create(Integer sourceId, WeatherData weatherData) {
        normalizedWeatherDataRepository.save(
                new NormalizedWeatherData(sourceId,
                                          weatherData.getTemperature(),
                                          weatherData.getHumidity(),
                                          LocalDateTime.now())
        );
    }

}

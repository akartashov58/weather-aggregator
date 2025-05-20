package ru.akartashov93.weatheraggregator.service.normalizer;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.akartashov93.weatheraggregator.service.dto.WeatherData;

public interface WeatherPayloadNormalizer {

    WeatherData normalize(String payload) throws JsonProcessingException;
}

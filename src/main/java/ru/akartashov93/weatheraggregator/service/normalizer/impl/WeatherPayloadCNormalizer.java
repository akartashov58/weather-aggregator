package ru.akartashov93.weatheraggregator.service.normalizer.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.akartashov93.weatheraggregator.service.dto.WeatherData;
import ru.akartashov93.weatheraggregator.service.integration.dto.WeatherCDto;
import ru.akartashov93.weatheraggregator.service.normalizer.WeatherPayloadNormalizer;

@Component
@RequiredArgsConstructor
public class WeatherPayloadCNormalizer implements WeatherPayloadNormalizer {

    private final ObjectMapper objectMapper;

    @Override
    public WeatherData normalize(String payload) throws JsonProcessingException {
        WeatherCDto dto = objectMapper.readValue(payload, WeatherCDto.class);
        WeatherCDto.WeatherDetail weather = dto.getWeather();
        return new WeatherData(weather.getT(), weather.getH());
    }
}

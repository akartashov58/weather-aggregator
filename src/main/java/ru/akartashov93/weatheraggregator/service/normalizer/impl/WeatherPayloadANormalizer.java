package ru.akartashov93.weatheraggregator.service.normalizer.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.akartashov93.weatheraggregator.service.dto.WeatherData;
import ru.akartashov93.weatheraggregator.service.integration.dto.WeatherADto;
import ru.akartashov93.weatheraggregator.service.normalizer.WeatherPayloadNormalizer;

@Component
@RequiredArgsConstructor
public class WeatherPayloadANormalizer implements WeatherPayloadNormalizer {

    private final ObjectMapper objectMapper;

    @Override
    public WeatherData normalize(String payload) throws JsonProcessingException {
        WeatherADto dto = objectMapper.readValue(payload, WeatherADto.class);
        return new WeatherData(dto.getTemp(), dto.getHum());
    }
}

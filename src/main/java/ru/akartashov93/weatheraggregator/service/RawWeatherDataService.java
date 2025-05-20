package ru.akartashov93.weatheraggregator.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.akartashov93.weatheraggregator.model.RawWeatherData;
import ru.akartashov93.weatheraggregator.repository.RawWeatherDataRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RawWeatherDataService {

    private final RawWeatherDataRepository rawWeatherDataRepository;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void create(Integer sourceId, String payload) {
        rawWeatherDataRepository.save(new RawWeatherData(sourceId, payload, LocalDateTime.now()));
    }
}

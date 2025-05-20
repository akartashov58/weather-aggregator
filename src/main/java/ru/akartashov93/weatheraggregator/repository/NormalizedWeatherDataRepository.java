package ru.akartashov93.weatheraggregator.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.akartashov93.weatheraggregator.model.NormalizedWeatherData;

/**
 * Репозиторий нормализованных данных погоды
 */
@Repository
public interface NormalizedWeatherDataRepository extends CrudRepository<NormalizedWeatherData, Long> {
}

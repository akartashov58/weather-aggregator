package ru.akartashov93.weatheraggregator.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.akartashov93.weatheraggregator.model.RawWeatherData;

/**
 * Репозиторий "сырых" данных погоды
 */
@Repository
public interface RawWeatherDataRepository extends CrudRepository<RawWeatherData, Long> {
}

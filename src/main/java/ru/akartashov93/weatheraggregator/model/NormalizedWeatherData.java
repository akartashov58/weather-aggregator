package ru.akartashov93.weatheraggregator.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Сущность нормализованных данных погоды
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
public class NormalizedWeatherData {

    public NormalizedWeatherData(Integer sourceId, Double temperature, Double humidity, LocalDateTime createDate) {
        this.sourceId = sourceId;
        this.temperature = temperature;
        this.humidity = humidity;
        this.createDate = createDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "source_id")
    private Integer sourceId;

    @Column(name = "temperature")
    private Double temperature;

    @Column(name = "humidity")
    private Double humidity;

    @Column(name = "create_date")
    private LocalDateTime createDate;
}

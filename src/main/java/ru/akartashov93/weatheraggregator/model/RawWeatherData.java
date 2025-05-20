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
 * Сущность "сырых" данных погоды от источника
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
public class RawWeatherData {

    public RawWeatherData(Integer sourceId, String payload, LocalDateTime createDate) {
        this.sourceId = sourceId;
        this.payload = payload;
        this.createDate = createDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "source_id")
    private Integer sourceId;

    @Column(name = "payload")
    private String payload;

    @Column(name = "create_date")
    private LocalDateTime createDate;
}

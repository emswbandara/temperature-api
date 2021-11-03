package com.temperature.api.entity;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TEMPERATURE_READING")
public class TemperatureReadingEntity {

    private long id;
    private String temperature;
    private OffsetDateTime recordedTime;

    public TemperatureReadingEntity() {

    }

    public TemperatureReadingEntity(String temperature, OffsetDateTime recordedTime) {

        this.temperature = temperature;
        this.recordedTime = recordedTime;
    }

    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "TEMPERATURE", nullable = false)
    public String getTemperature() {
        return temperature;
    }
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    @Column(name = "RECORDED_TIME", nullable = false)
    public OffsetDateTime getRecordedTime() {
        return recordedTime;
    }
    public void setRecordedTime(OffsetDateTime recordedTime) {
        this.recordedTime = recordedTime;
    }
}
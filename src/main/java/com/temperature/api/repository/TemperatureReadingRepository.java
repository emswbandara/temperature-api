package com.temperature.api.repository;

import java.time.OffsetDateTime;
import java.util.List;

import com.temperature.api.entity.TemperatureReadingEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperatureReadingRepository extends CrudRepository<TemperatureReadingEntity, Long> {
    
    List<TemperatureReadingEntity> findAllByRecordedTimeBetween(OffsetDateTime start, OffsetDateTime end);
}

package com.temperature.api.service;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.temperature.api.TemperatureApiDelegate;
import com.temperature.api.entity.TemperatureReadingEntity;
import com.temperature.api.model.TemperatureReading;
import com.temperature.api.repository.TemperatureReadingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TemperatureApiDelegateImpl implements TemperatureApiDelegate {
    
    @Autowired
    private TemperatureReadingRepository tRepository;

    @Override
    public ResponseEntity<Void> saveTemperature(TemperatureReading temperatureReading) {
        
        tRepository.save(new TemperatureReadingEntity(temperatureReading.getTemperature(), temperatureReading.getRecordedAt()));
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<List<TemperatureReading>> fetchTemperature(String start, String end) {

        List<TemperatureReading> tReadings = null;
        OffsetDateTime startTime = validateDateTimeInputParameter(start);
        OffsetDateTime endTime = validateDateTimeInputParameter(end);
        List<TemperatureReadingEntity> tEntities = tRepository.findAllByRecordedTimeBetween(startTime, endTime);

        if (tEntities == null || tEntities.isEmpty()) {
            return ResponseEntity.ok(Collections.emptyList());
        }

        tReadings = tEntities.stream().map(entity -> {
            TemperatureReading tReading = new TemperatureReading();
            tReading.setTemperature(entity.getTemperature());
            tReading.setRecordedAt(entity.getRecordedTime().withOffsetSameInstant(ZoneOffset.UTC));
            return tReading;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(tReadings);
    }

    @Override
    public ResponseEntity<Void> bulkSaveTemperature(List<TemperatureReading> temperatureReading) {

        if (temperatureReading == null || temperatureReading.isEmpty()) {
            return ResponseEntity.ok(null);
        }

        List<TemperatureReadingEntity> tEntities = temperatureReading.stream().map(reading -> {
            TemperatureReadingEntity entity = new TemperatureReadingEntity();
            entity.setTemperature(reading.getTemperature());
            entity.setRecordedTime(reading.getRecordedAt());
            return entity;
        }).collect(Collectors.toList());
        tRepository.saveAll(tEntities);
        return ResponseEntity.ok(null);
    }

    private OffsetDateTime validateDateTimeInputParameter(String dateTime) {

        try {
            OffsetDateTime offsetDateTime = OffsetDateTime.parse(dateTime);
            return offsetDateTime;
        } catch(DateTimeParseException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid parameter: '" + dateTime + "'. 'start' and 'end' parameters should be in ISO 8601 format.");
        }
    }
}

package com.temperature.api.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.temperature.api.entity.TemperatureReadingEntity;
import com.temperature.api.model.TemperatureReading;
import com.temperature.api.repository.TemperatureReadingRepository;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;


@ExtendWith(MockitoExtension.class)
public class TemperatureApiDelegateImplTest {

	@InjectMocks
	private TemperatureApiDelegateImpl tApiDelegate;
	
    @Mock
	private TemperatureReadingRepository tRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

	@Test
	public void testFetchTemperature() throws Exception {

        when(tRepository.findAllByRecordedTimeBetween(any(), any())).thenReturn(Collections.emptyList());

        ResponseEntity response = tApiDelegate.fetchTemperature("2021-08-25T00:00:00Z", "2021-08-26T00:00:00Z");
        assertEquals(HttpStatus.OK, response.getStatusCode());
	}

    @Test
	void testFetchTemperatureWithInvalidInput() throws Exception {

        ResponseStatusException exception = assertThrows(
            ResponseStatusException.class,
            () -> tApiDelegate.fetchTemperature("invalid-start-date", "invalid-end-date"),
           "Expected fetchTemperature() to throw an exception for invalid parameters."
    );

    assertTrue(exception.getMessage().contains("Invalid parameter"));
	}

    @Test
	public void testSaveTemperature() throws Exception {


        OffsetDateTime dateTime = OffsetDateTime.parse("2021-08-25T00:00:00Z");

        TemperatureReadingEntity entity = new TemperatureReadingEntity();
        entity.setId(1);
        entity.setTemperature("27");
        entity.setRecordedTime(dateTime);
        when(tRepository.save(any())).thenReturn(entity);

        TemperatureReading reading = new TemperatureReading();
        reading.setTemperature("27");
        reading.setRecordedAt(dateTime);
        ResponseEntity response = tApiDelegate.saveTemperature(reading);
        
        assertEquals(HttpStatus.OK, response.getStatusCode());
	}

    @Test
	public void testBulkSaveemperature() throws Exception {

        OffsetDateTime dateTime1 = OffsetDateTime.parse("2021-08-25T00:00:00Z");
        OffsetDateTime dateTime2 = OffsetDateTime.parse("2021-08-26T00:00:00Z");

        TemperatureReadingEntity entity1 = new TemperatureReadingEntity();
        entity1.setId(1);
        entity1.setTemperature("27");
        entity1.setRecordedTime(dateTime1);

        TemperatureReadingEntity entity2 = new TemperatureReadingEntity();
        entity2.setId(2);
        entity2.setTemperature("28");
        entity2.setRecordedTime(dateTime2);

        List<TemperatureReadingEntity> entities = new ArrayList<>();
        entities.add(entity1);
        entities.add(entity2);

        when(tRepository.saveAll(any())).thenReturn(entities);

        TemperatureReading reading = new TemperatureReading();
        reading.setTemperature("27");
        reading.setRecordedAt(dateTime1);

        List<TemperatureReading> readings = new ArrayList<>();
        readings.add(reading);
        ResponseEntity response = tApiDelegate.bulkSaveTemperature(readings);
        
        assertEquals(HttpStatus.OK, response.getStatusCode());
	}
}

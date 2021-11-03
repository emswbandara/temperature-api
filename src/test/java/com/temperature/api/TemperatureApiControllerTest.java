package com.temperature.api;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;

import com.temperature.api.service.TemperatureApiDelegateImpl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest
class TemperatureApiControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	TemperatureApiDelegateImpl tApiDelegate;
	
	@Test
	void testFetchTemperature() throws Exception {

		when(tApiDelegate.fetchTemperature(anyString(), anyString())).thenReturn(ResponseEntity.ok(Collections.emptyList()));

		mockMvc.perform(MockMvcRequestBuilders.get("/temperature/fetch?start=2021-08-25T00:00:00Z&end=2021-08-27T00:00:00Z")
		.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());		
	}

    @Test
	void testFetchTemperatureForInvalidInput() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/temperature/fetch")
		.accept(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
		
	}

}

package com.temperature.api;

import com.temperature.api.model.Error;
import java.util.List;
import com.temperature.api.model.TemperatureReading;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * A delegate to be called by the {@link TemperatureApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-08-21T20:23:20.340589+05:30[Asia/Colombo]")

public interface TemperatureApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /temperature/bulk-save : Bulk Save temperature
     * Bulk Save temperature
     *
     * @param temperatureReading  (required)
     * @return Accepted (status code 202)
     *         or Bad Request (status code 400)
     *         or Unexpected Error (status code 500)
     * @see TemperatureApi#bulkSaveTemperature
     */
    default ResponseEntity<Void> bulkSaveTemperature(List<TemperatureReading> temperatureReading) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /temperature/fetch : Fetch Temperature Data
     *
     * @param start The start time for fetching temperature readings (required)
     * @param end The end time for fetching temperature readings (required)
     * @return Successful Response (status code 200)
     *         or Data not found (status code 404)
     * @see TemperatureApi#fetchTemperature
     */
    default ResponseEntity<List<TemperatureReading>> fetchTemperature(String start,
        String end) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"recordedAt\" : \"2021-08-30T08:30:00Z\", \"temperature\" : \"27°C\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /temperature/save : Save temperature
     * Save temperature
     *
     * @param temperatureReading  (required)
     * @return Successful Response (status code 200)
     *         or Bad Request (status code 400)
     *         or Unexpected Error (status code 500)
     * @see TemperatureApi#saveTemperature
     */
    default ResponseEntity<Void> saveTemperature(TemperatureReading temperatureReading) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}

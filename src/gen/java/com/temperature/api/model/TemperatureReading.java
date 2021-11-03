package com.temperature.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TemperatureReading
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-08-21T20:23:20.340589+05:30[Asia/Colombo]")

public class TemperatureReading   {
  @JsonProperty("temperature")
  private String temperature;

  @JsonProperty("recordedAt")
  private OffsetDateTime recordedAt;

  public TemperatureReading temperature(String temperature) {
    this.temperature = temperature;
    return this;
  }

  /**
   * Get temperature
   * @return temperature
  */
  @ApiModelProperty(example = "27°C", required = true, value = "")
  @NotNull


  public String getTemperature() {
    return temperature;
  }

  public void setTemperature(String temperature) {
    this.temperature = temperature;
  }

  public TemperatureReading recordedAt(OffsetDateTime recordedAt) {
    this.recordedAt = recordedAt;
    return this;
  }

  /**
   * Recorded time in ISO 8601 full-time format.
   * @return recordedAt
  */
  @ApiModelProperty(example = "2021-08-30T08:30Z", required = true, value = "Recorded time in ISO 8601 full-time format.")
  @NotNull

  @Valid

  public OffsetDateTime getRecordedAt() {
    return recordedAt;
  }

  public void setRecordedAt(OffsetDateTime recordedAt) {
    this.recordedAt = recordedAt;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TemperatureReading temperatureReading = (TemperatureReading) o;
    return Objects.equals(this.temperature, temperatureReading.temperature) &&
        Objects.equals(this.recordedAt, temperatureReading.recordedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(temperature, recordedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TemperatureReading {\n");
    
    sb.append("    temperature: ").append(toIndentedString(temperature)).append("\n");
    sb.append("    recordedAt: ").append(toIndentedString(recordedAt)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}


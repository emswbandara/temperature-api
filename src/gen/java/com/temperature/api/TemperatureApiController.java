package com.temperature.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-08-21T20:23:20.340589+05:30[Asia/Colombo]")

@Controller
@RequestMapping("${openapi.temperatureReadings.base-path:}")
public class TemperatureApiController implements TemperatureApi {

    private final TemperatureApiDelegate delegate;

    public TemperatureApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) TemperatureApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new TemperatureApiDelegate() {});
    }

    @Override
    public TemperatureApiDelegate getDelegate() {
        return delegate;
    }

}

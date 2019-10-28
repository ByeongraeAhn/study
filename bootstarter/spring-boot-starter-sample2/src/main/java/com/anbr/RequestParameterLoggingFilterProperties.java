package com.anbr;

import org.slf4j.event.Level;
import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties(prefix = "spring.mvc.request-parameter-logging-filter")
@Data 
public class RequestParameterLoggingFilterProperties {
    private boolean enabled;
    private Level level;
    // getters and setters
}
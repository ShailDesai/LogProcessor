package com.example.logprocessor.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import java.util.Map;

@Data
public class LogRequestDto {
    @NotBlank(message = "Log message is required")
    private String message;
    
    private String level;
    private String loggerName;
    private String threadName;
    private String host;
    private String correlationId;
    private String environment;
    private String eventType;
    private String userId;
    private String appVersion;
    private Long responseTime;
    private Map<String, Object> metadata;
}

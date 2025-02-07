package com.example.logprocessor.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.DateFormat;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "logs")
public class LogEntry {
    @Id
    private String id;

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

    // Store the timestamp as epoch milliseconds.
    @Field(type = FieldType.Date, format = DateFormat.epoch_millis)
    private Long timestamp;
}

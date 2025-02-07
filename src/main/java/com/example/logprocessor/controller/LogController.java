package com.example.logprocessor.controller;

import com.example.logprocessor.model.LogEntry;
import com.example.logprocessor.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/logs")
@Slf4j
public class LogController {

    private final LogService logService;

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }

    @PostMapping
    public CompletableFuture<ResponseEntity<LogEntry>> createLog(@Valid @RequestBody LogEntry logEntry) {
        if (logEntry.getTimestamp() == null) {
            logEntry.setTimestamp(System.currentTimeMillis());
        }
        return logService.saveLogAsync(logEntry)
                .thenApply(savedEntry -> new ResponseEntity<>(savedEntry, HttpStatus.CREATED))
                .exceptionally(ex -> {
                    log.error("Error creating log entry", ex);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                });
    }

    @GetMapping("/recent")
    public CompletableFuture<ResponseEntity<List<LogEntry>>> getRecentLogs() {
        return logService.getRecentLogsAsync()
                .thenApply(logs -> new ResponseEntity<>(logs, HttpStatus.OK))
                .exceptionally(ex -> {
                    log.error("Error retrieving recent logs", ex);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                });
    }
}

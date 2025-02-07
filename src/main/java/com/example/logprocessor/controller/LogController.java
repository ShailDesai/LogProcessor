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

@RestController
@RequestMapping("/api/logs")
@Slf4j  // Lombok annotation to provide a logger
public class LogController {

    private final LogService logService;

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }

    @PostMapping
    public ResponseEntity<LogEntry> createLog(@Valid @RequestBody LogEntry logEntry) {
        try {
            if (logEntry.getTimestamp() == null) {
                logEntry.setTimestamp(System.currentTimeMillis());
            }
            LogEntry savedEntry = logService.saveLog(logEntry);
            return new ResponseEntity<>(savedEntry, HttpStatus.CREATED);
        } catch (Exception ex) {
            log.error("Error creating log entry", ex);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/recent")
    public ResponseEntity<List<LogEntry>> getRecentLogs() {
        try {
            List<LogEntry> logs = logService.getRecentLogs();
            return new ResponseEntity<>(logs, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Error retrieving recent logs", ex);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

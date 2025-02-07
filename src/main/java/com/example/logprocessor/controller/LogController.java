package com.example.logprocessor.controller;

import com.example.logprocessor.dto.LogRequestDto;
import com.example.logprocessor.model.LogEntry;
import com.example.logprocessor.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class LogController {

    private final LogService logService;

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }

    // Old method using a DTO:
    // @PostMapping
    // public LogEntry createLog(@Valid @RequestBody LogRequestDto logRequestDto) {
    //     return logService.saveLog(logRequestDto);
    // }

    // New method using LogEntry directly:
    @PostMapping
    public LogEntry createLog(@Valid @RequestBody LogEntry logEntry) {
        // If the timestamp is not provided, set it automatically (using epoch milliseconds).
        if (logEntry.getTimestamp() == null) {
            logEntry.setTimestamp(System.currentTimeMillis());
        }
        return logService.saveLog(logEntry);
    }

    @GetMapping("/recent")
    public List<LogEntry> getRecentLogs() {
        return logService.getRecentLogs();
    }
}

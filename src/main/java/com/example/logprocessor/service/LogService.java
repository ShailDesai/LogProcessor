package com.example.logprocessor.service;

import com.example.logprocessor.dto.LogRequestDto;
import com.example.logprocessor.model.LogEntry;
import com.example.logprocessor.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
public class LogService {

    private final LogRepository logRepository;

    @Autowired
    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public LogEntry saveLog(LogEntry logEntry) {
        // Optionally, if the timestamp is not set, set it here as well.
        if (logEntry.getTimestamp() == null) {
            logEntry.setTimestamp(System.currentTimeMillis());
        }
        return logRepository.save(logEntry);
    }

    // Retrieve the top 3 most recent logs
    public List<LogEntry> getRecentLogs() {
        return logRepository.findAll(PageRequest.of(0, 3)).getContent();
    }
}


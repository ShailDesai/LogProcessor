package com.example.logprocessor.service;

import com.example.logprocessor.model.LogEntry;
import com.example.logprocessor.repository.LogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LogService {

    private final LogRepository logRepository;

    @Autowired
    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public LogEntry saveLog(LogEntry logEntry) {
        try {
            return logRepository.save(logEntry);
        } catch (Exception e) {
            log.error("Error saving log entry: {}", logEntry, e);
          
            throw e;
        }
    }

    public List<LogEntry> getRecentLogs() {
        try {
            return logRepository.findAll(PageRequest.of(0, 3)).getContent();
        } catch (Exception e) {
            log.error("Error fetching recent logs", e);
            throw e;
        }
    }
}

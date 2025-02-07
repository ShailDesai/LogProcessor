package com.example.logprocessor.service;

import com.example.logprocessor.model.LogEntry;
import com.example.logprocessor.repository.LogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class LogService {

    private final LogRepository logRepository;

    @Autowired
    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Async
    public CompletableFuture<LogEntry> saveLogAsync(LogEntry logEntry) {
        try {
            LogEntry savedEntry = logRepository.save(logEntry);
            return CompletableFuture.completedFuture(savedEntry);
        } catch (Exception e) {
            log.error("Error saving log entry: {}", logEntry, e);
            CompletableFuture<LogEntry> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Async
    public CompletableFuture<List<LogEntry>> getRecentLogsAsync() {
        try {
            List<LogEntry> logs = logRepository.findAll(PageRequest.of(0, 3)).getContent();
            return CompletableFuture.completedFuture(logs);
        } catch (Exception e) {
            log.error("Error fetching recent logs", e);
            CompletableFuture<List<LogEntry>> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }
}

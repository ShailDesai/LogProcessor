package com.example.logprocessor.repository;

import com.example.logprocessor.model.LogEntry;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface LogRepository extends ElasticsearchRepository<LogEntry, String> {
}

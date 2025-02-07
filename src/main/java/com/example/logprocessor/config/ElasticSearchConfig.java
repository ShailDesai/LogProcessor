package com.example.logprocessor.config;

// import com.example.logprocessor.model.LocalDateTimeConverter;
// import com.example.logprocessor.model.LocalDateTimeToLongConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.convert.ElasticsearchCustomConversions;

import java.util.List;

@Configuration
public class ElasticSearchConfig {
    @Bean
    public ElasticsearchCustomConversions elasticsearchCustomConversions() {
        return new ElasticsearchCustomConversions(List.of(
            // new LocalDateTimeConverter(),
            // new LocalDateTimeToLongConverter()
        ));
    }
}


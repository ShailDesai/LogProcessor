# Use the official Elasticsearch image
FROM docker.elastic.co/elasticsearch/elasticsearch:8.11.2

# Set environment variable for single-node cluster
ENV discovery.type=single-node

# Copy the data from your machine into the container
COPY ./data /usr/share/elasticsearch/data

# Ensure correct permissions (important for Elasticsearch)
RUN chown -R elasticsearch:elasticsearch /usr/share/elasticsearch/data

# Expose default Elasticsearch ports
EXPOSE 9200 9300


Question:Why I choose Elastic Search as Database?

Answer: For our log data ingestion and retrieval application, I have selected Elasticsearch as the optimal database solution. Elasticsearch is a distributed, RESTful search and analytics engine that is purpose-built to handle large volumes of unstructured data. Its core architecture is based on indexing, which converts raw log entries into a format that supports fast, complex searches and aggregations—features that are essential for processing and analyzing log data in real time.

One of the main advantages of Elasticsearch is its scalability. It is designed to scale horizontally, meaning that as the volume of log data increases, additional nodes can be added to the cluster to maintain performance. This scalability is crucial for handling the write-heavy workloads typical in log ingestion systems. Moreover, Elasticsearch’s support for bulk operations allows it to efficiently process high-velocity data streams, ensuring that the system remains responsive under heavy load.

In contrast, traditional SQL databases are primarily optimized for structured, relational data and transactional operations, making them less flexible for the dynamic and unstructured nature of log data. Although NoSQL options like MongoDB can store unstructured data, they often lack the robust full-text search capabilities and specialized analytics functions that Elasticsearch provides.Overall, Elasticsearch offers a combination of high-speed ingestion, real-time search, and scalable architecture, making it well suited for our log management system. These features ensure efficient data storage and retrieval while supporting effective monitoring, alerting, and historical analysis of log data.



Data in below example is dummy Data 

Images For Post and Get Request

Post Request for Saving the Log Data
<img width="1229" alt="Screenshot 2025-02-07 at 6 52 00 AM" src="https://github.com/user-attachments/assets/6abee5fd-c26a-4e76-a81c-07f253a0b14b" />

Get Request to Get top 3 Logs
<img width="1391" alt="Screenshot 2025-02-07 at 6 51 39 AM" src="https://github.com/user-attachments/assets/e7ecad68-0eb1-4df0-b074-b3fea6cd90cb" />



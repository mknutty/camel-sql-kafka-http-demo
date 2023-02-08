# camel-sql-kafka-http-demo

This app demonstrates using Spring's @Scheduled and Apache Camel's Kafka, HTTP and SQL components and Spring Web to, on a schedule:
1. Trigger a direct Camel route
2. Direct route queries the database using the SQL component
3. Splits the recordset into individual messages
4. Converts to JSON
5. Publishes the message to Kafka using the Kafka component to asynchronously process the message so that the scheduled process can terminate. 
6. Another Camel Route consumes the Kafka topic using the Kafka component.
7. The JSON is converted to a POJO. Alternatively, if the needs are simple, jsonpath could be used.
8. Using the Camel HTTP component, call a web endpoint (self hosted in the service)

Note: Camel's Scheduler component could be used, but Spring supports clustering with Shedlock.

Note that Kafka can be easily replace with ActiveMQ, RabbitMQ, SQS or etc.

Requires kafka running locally on the standard port.

Requires java 11+

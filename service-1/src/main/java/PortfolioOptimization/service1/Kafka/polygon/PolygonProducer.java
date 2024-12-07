package PortfolioOptimization.service1.Kafka.polygon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/*
-Kafka Producer is the final step in the flow of this microservice.
- Kafka Producer publishes the data to the appropriate kafka topics.
- For AlphaVantage --> TOPIC is --> "alphavantage-data"
*/

@Service
public class PolygonProducer {

    private static final String TOPIC = "polygon-data";

    @Autowired
    @Qualifier("polygonKafkaTemplate")
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message)
    {
        kafkaTemplate.send(TOPIC, message);
    }
}
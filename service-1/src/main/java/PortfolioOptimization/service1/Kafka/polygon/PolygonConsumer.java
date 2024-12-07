//package PortfolioOptimization.service1.Kafka.polygon;
//
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//@Service
//public class PolygonConsumer {
//
//    private static final String TOPIC = "polygon-data";
//
//    // This method listens to messages from the Kafka topic
//    @KafkaListener(topics = TOPIC, groupId = "${kafka.polygon.group-id}")
//    public void consumeMessage(Object message) {
//        System.out.println("Received message: " + message);
//
//        // Handle the message logic here
//        if (message instanceof PolygonSma) {
//            processPolygonSma((PolygonSma) message);
//        } else if (message instanceof PolygonEma) {
//            processPolygonEma((PolygonEma) message);
//        } else if (message instanceof PolygonMacd) {
//            processPolygonMacd((PolygonMacd) message);
//        } else if (message instanceof PolygonRsi) {
//            processPolygonRsi((PolygonRsi) message);
//        } else {
//            System.out.println("Unknown message type: " + message.getClass().getSimpleName());
//        }
//    }
//
//    // Add methods to process each message type (without saving to DB)
//    private void processPolygonSma(PolygonSma sma) {
//        // Perform any processing needed for SMA data
//        System.out.println("Processing SMA data: " + sma);
//    }
//
//    private void processPolygonEma(PolygonEma ema) {
//        // Perform any processing needed for EMA data
//        System.out.println("Processing EMA data: " + ema);
//    }
//
//    private void processPolygonMacd(PolygonMacd macd) {
//        // Perform any processing needed for MACD data
//        System.out.println("Processing MACD data: " + macd);
//    }
//
//    private void processPolygonRsi(PolygonRsi rsi) {
//        // Perform any processing needed for RSI data
//        System.out.println("Processing RSI data: " + rsi);
//    }
//}
package PortfolioOptimization.service1.Kafka.polygon;

import PortfolioOptimization.service1.dto.polygon.PolygonEmaDTO;
import PortfolioOptimization.service1.dto.polygon.PolygonMacdDTO;
import PortfolioOptimization.service1.dto.polygon.PolygonRsiDTO;
import PortfolioOptimization.service1.dto.polygon.PolygonSmaDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PolygonConsumer {

    private static final String TOPIC = "polygon-data";

    // This method listens to messages from the Kafka topic
    @KafkaListener(topics = TOPIC, groupId = "${kafka.polygon.group-id}")
    public void consumeMessage(Object message) {
        System.out.println("Received message: " + message);

        // Handle the message logic here
        if (message instanceof PolygonSmaDTO) {
            processPolygonSma((PolygonSmaDTO) message);
        } else if (message instanceof PolygonEmaDTO) {
            processPolygonEma((PolygonEmaDTO) message);
        } else if (message instanceof PolygonMacdDTO) {
            processPolygonMacd((PolygonMacdDTO) message);
        } else if (message instanceof PolygonRsiDTO) {
            processPolygonRsi((PolygonRsiDTO) message);
        } else {
            System.out.println("Unknown message type: " + message.getClass().getSimpleName());
        }
    }

    // Add methods to process each message type (without saving to DB)
    private void processPolygonSma(PolygonSmaDTO sma) {
        // Process SMA data logic
        System.out.println("Processing SMA data: " + sma);
        // Add any specific processing required for SMA data
    }

    private void processPolygonEma(PolygonEmaDTO ema) {
        // Process EMA data logic
        System.out.println("Processing EMA data: " + ema);
        // Add any specific processing required for EMA data
    }

    private void processPolygonMacd(PolygonMacdDTO macd) {
        // Process MACD data logic
        System.out.println("Processing MACD data: " + macd);
        // Add any specific processing required for MACD data
    }

    private void processPolygonRsi(PolygonRsiDTO rsi) {
        // Process RSI data logic
        System.out.println("Processing RSI data: " + rsi);
        // Add any specific processing required for RSI data
    }
}

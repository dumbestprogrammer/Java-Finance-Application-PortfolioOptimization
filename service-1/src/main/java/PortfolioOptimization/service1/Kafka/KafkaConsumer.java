//package PortfolioOptimization.service1.Kafka;
//
//import PortfolioOptimization.service1.dao.alpha.*;
//import PortfolioOptimization.service1.entity.alpha.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//@Service
//public class KafkaConsumer {
//
//    private static final String TOPIC = "alphavantage-data";
//
//    @Autowired
//    private AlphaVantageMarketStatusRepository marketStatusRepository;
//    @Autowired
//    private AlphaVantageGlobalQuoteRepository globalQuoteRepository;
//    @Autowired
//    private AlphaVantageSymbolSearchRepository symbolSearchRepository;
//    @Autowired
//    private AlphaVantageTimeSeriesIntradayRepository timeSeriesIntradayRepository;
//    @Autowired
//    private AlphaVantageTopGainersLosersRepository topGainersLosersRepository;
//    @Autowired
//    private AlphaVantageMarketNewsSentimentRepository marketNewsSentimentRepository;
//    @Autowired
//    private AlphaVantageAnalyticsSlidingWindowRepository analyticsSlidingWindowRepository;
//
//    @KafkaListener(topics = TOPIC, groupId = "${kafka.alpha-vantage.group-id}")
//    public void consumeMessage(Object message) {
//        // Assuming message is in JSON format and contains a field to determine the type
//        System.out.println("Received message: " + message);
//
//        if (message instanceof AlphaVantageMarketStatus)
//        {
//            marketStatusRepository.save((AlphaVantageMarketStatus) message);
//        }
//        else if (message instanceof AlphaVantageGlobalQuote)
//        {
//            globalQuoteRepository.save((AlphaVantageGlobalQuote) message);
//        }
//        else if (message instanceof AlphaVantageSymbolSearch)
//        {
//            symbolSearchRepository.save((AlphaVantageSymbolSearch) message);
//        }
//        else if (message instanceof AlphaVantageTimeSeriesIntraday)
//        {
//            timeSeriesIntradayRepository.save((AlphaVantageTimeSeriesIntraday) message);
//        }
//        else if (message instanceof AlphaVantageTopGainersLosers)
//        {
//            topGainersLosersRepository.save((AlphaVantageTopGainersLosers) message);
//        }
//        else if (message instanceof AlphaVantageMarketNewsSentiment)
//        {
//            marketNewsSentimentRepository.save((AlphaVantageMarketNewsSentiment) message);
//        }
//        else if (message instanceof AlphaVantageAnalyticsSlidingWindow)
//        {
//            analyticsSlidingWindowRepository.save((AlphaVantageAnalyticsSlidingWindow) message);
//        } else
//        {
//            System.out.println("Unknown message type: " + message.getClass().getSimpleName());
//        }
//    }
//}

package PortfolioOptimization.service1.Kafka;

import PortfolioOptimization.service1.dto.alpha.*;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final String TOPIC = "alphavantage-data";

    // This method listens to messages from the Kafka topic
    @KafkaListener(topics = TOPIC, groupId = "${kafka.alpha-vantage.group-id}")
    public void consumeMessage(Object message) {
        System.out.println("Received message: " + message);

        // Handle the message logic here
        if (message instanceof AlphaVantageMarketStatusDTO) {
            processMarketStatus((AlphaVantageMarketStatusDTO) message);
        } else if (message instanceof AlphaVantageGlobalQuoteDTO) {
            processGlobalQuote((AlphaVantageGlobalQuoteDTO) message);
        } else if (message instanceof AlphaVantageSymbolSearchDTO) {
            processSymbolSearch((AlphaVantageSymbolSearchDTO) message);
        } else if (message instanceof AlphaVantageTimeSeriesIntradayDTO) {
            processTimeSeriesIntraday((AlphaVantageTimeSeriesIntradayDTO) message);
        } else if (message instanceof AlphaVantageTopGainersLosersDTO) {
            processTopGainersLosers((AlphaVantageTopGainersLosersDTO) message);
        } else if (message instanceof AlphaVantageMarketNewsSentimentDTO) {
            processMarketNewsSentiment((AlphaVantageMarketNewsSentimentDTO) message);
        } else if (message instanceof AlphaVantageAnalyticsSlidingWindowDTO) {
            processAnalyticsSlidingWindow((AlphaVantageAnalyticsSlidingWindowDTO) message);
        } else {
            System.out.println("Unknown message type: " + message.getClass().getSimpleName());
        }
    }

    // Add methods to process each DTO (no DB operations)
    private void processMarketStatus(AlphaVantageMarketStatusDTO marketStatusDTO) {
        System.out.println("Processing Market Status: " + marketStatusDTO);
        // Perform any necessary processing here
    }

    private void processGlobalQuote(AlphaVantageGlobalQuoteDTO globalQuoteDTO) {
        System.out.println("Processing Global Quote: " + globalQuoteDTO);
        // Perform any necessary processing here
    }

    private void processSymbolSearch(AlphaVantageSymbolSearchDTO symbolSearchDTO) {
        System.out.println("Processing Symbol Search: " + symbolSearchDTO);
        // Perform any necessary processing here
    }

    private void processTimeSeriesIntraday(AlphaVantageTimeSeriesIntradayDTO timeSeriesDTO) {
        System.out.println("Processing Time Series Intraday: " + timeSeriesDTO);
        // Perform any necessary processing here
    }

    private void processTopGainersLosers(AlphaVantageTopGainersLosersDTO topGainersLosersDTO) {
        System.out.println("Processing Top Gainers Losers: " + topGainersLosersDTO);
        // Perform any necessary processing here
    }

    private void processMarketNewsSentiment(AlphaVantageMarketNewsSentimentDTO marketNewsSentimentDTO) {
        System.out.println("Processing Market News Sentiment: " + marketNewsSentimentDTO);
        // Perform any necessary processing here
    }

    private void processAnalyticsSlidingWindow(AlphaVantageAnalyticsSlidingWindowDTO analyticsSlidingWindowDTO) {
        System.out.println("Processing Analytics Sliding Window: " + analyticsSlidingWindowDTO);
        // Perform any necessary processing here
    }
}

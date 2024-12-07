package PortfolioOptimization.service1.controller;

import PortfolioOptimization.service1.Kafka.KafkaProducer;
import PortfolioOptimization.service1.Service.AlphaVantageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/*
The controller class is the entry point of my application.
Handles incomming HTTP requests, process them and delegates business logic to the service layer.

       User requests a piece        Controller           Sends it to
-----> of information or the -----> processes the -----> the service layer
       stock data                   IP                   for processing
*/
@RestController
@RequestMapping("alpha")
public class AlphaVantageController {

    @Autowired
    AlphaVantageService alphaVantageService;

    @Autowired
    KafkaProducer kafkaProducer;

    @GetMapping("/intraday")
    public ResponseEntity<String> getTimeSeriesIntraday(
            @RequestParam String symbol,
            @RequestParam String interval,
            @RequestParam(required = false) String adjusted,
            @RequestParam(required = false) String extendedHours,
            @RequestParam(required = false) String month,
            @RequestParam(required = false) String outputsize,
            @RequestParam(required = false) String datatype) {
        String data = alphaVantageService.getTimeSeriesIntraday(symbol, interval, adjusted, extendedHours, month, outputsize, datatype);
        kafkaProducer.sendMessage(data);
        return ResponseEntity.status(HttpStatus.OK).body("AlphaVantage intraday Data sent to Kafka for processing");
    }

    @GetMapping("/global-quote")
    public ResponseEntity<String> getGlobalQuote(@RequestParam String symbol, @RequestParam(required = false) String datatype) {
        String data = alphaVantageService.getGlobalQuote(symbol, datatype);
        kafkaProducer.sendMessage(data);
        return ResponseEntity.status(HttpStatus.OK).body("AlphaVantage global-quote Data sent to Kafka for processing");
    }

    @GetMapping("/symbol-search")
    public ResponseEntity<String> searchSymbol(@RequestParam String keywords, @RequestParam(required = false) String datatype) {
        String data = alphaVantageService.searchSymbol(keywords, datatype);
        kafkaProducer.sendMessage(data);
        return ResponseEntity.status(HttpStatus.OK).body("AlphaVantage symbol-search Data sent to Kafka for processing");
    }

    @GetMapping("/market-status")
    public ResponseEntity<String> getMarketStatus(@RequestParam(required = false) String datatype) {
        String data = alphaVantageService.getMarketStatus(datatype);
        kafkaProducer.sendMessage(data);
        return ResponseEntity.status(HttpStatus.OK).body("AlphaVantage market-status Data sent to Kafka for processing");
    }

    @GetMapping("/news-sentiment")
    public ResponseEntity<String> getMarketNewsSentiment(
            @RequestParam String tickers,
            @RequestParam String topics,
            @RequestParam String timeFrom,
            @RequestParam String sort,
            @RequestParam String limit,
            @RequestParam(required = false) String datatype) {
        String data = alphaVantageService.getMarketNewsSentiment(tickers, topics, timeFrom, sort, limit, datatype);
        kafkaProducer.sendMessage(data);
        return ResponseEntity.status(HttpStatus.OK).body("AlphaVantage news-sentiment Data sent to Kafka for processing");
    }

    @GetMapping("/top-gainers-losers")
    public ResponseEntity<String> getTopGainersLosers(@RequestParam(required = false) String datatype) {
        String data = alphaVantageService.getTopGainersLosers(datatype);
        kafkaProducer.sendMessage(data);
        return ResponseEntity.status(HttpStatus.OK).body("AlphaVantage top-gainers-losers Data sent to Kafka for processing");
    }

    @GetMapping("/analytics-sliding-window")
    public ResponseEntity<String> getAnalyticsSlidingWindow(
            @RequestParam String symbols,
            @RequestParam String range,
            @RequestParam String ohlc,
            @RequestParam String interval,
            @RequestParam String windowSize,
            @RequestParam String calculations,
            @RequestParam(required = false) String datatype) {
        String data = alphaVantageService.getAnalyticsSlidingWindow(symbols, range, ohlc, interval, windowSize, calculations, datatype);
        kafkaProducer.sendMessage(data);
        return ResponseEntity.status(HttpStatus.OK).body("AlphaVantage analytics-sliding-window Data sent to Kafka for processing");
    }
}
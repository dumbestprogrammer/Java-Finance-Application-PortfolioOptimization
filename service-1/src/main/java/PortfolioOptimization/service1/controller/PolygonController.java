package PortfolioOptimization.service1.controller;

import PortfolioOptimization.service1.Kafka.polygon.PolygonProducer;
import PortfolioOptimization.service1.Service.PolygonService;
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
@RequestMapping("/polygon")
public class PolygonController {

    @Autowired
    private PolygonService polygonService;

    @Autowired
    private PolygonProducer polygonProducer;

    @GetMapping("/sma")
    public ResponseEntity<String> getSmaData(
            @RequestParam String symbol,
            @RequestParam String timespan,
            @RequestParam boolean adjusted,
            @RequestParam int windowSize,
            @RequestParam String seriesType,
            @RequestParam String order) {
        String data = polygonService.getSma(symbol, timespan, adjusted, windowSize, seriesType, order);
        polygonProducer.sendMessage(data);
        return ResponseEntity.status(HttpStatus.OK).body("Polygon sma Data sent to Kafka for processing");
    }

    @GetMapping("/ema")
    public ResponseEntity<String> getEmaData(
            @RequestParam String symbol,
            @RequestParam String timespan,
            @RequestParam boolean adjusted,
            @RequestParam int windowSize,
            @RequestParam String seriesType,
            @RequestParam String order) {
        String data = polygonService.getEma(symbol, timespan, adjusted, windowSize, seriesType, order);
        polygonProducer.sendMessage(data);
        return ResponseEntity.status(HttpStatus.OK).body("Polygon ema Data sent to Kafka for processing");
    }

    @GetMapping("/macd")
    public ResponseEntity<String> getMacdData(
            @RequestParam String symbol,
            @RequestParam String timespan,
            @RequestParam boolean adjusted,
            @RequestParam int shortWindowSize,
            @RequestParam int longWindowSize,
            @RequestParam int signalWindowSize,
            @RequestParam String seriesType,
            @RequestParam String order) {
        String data = polygonService.getMacd(symbol, timespan, adjusted, shortWindowSize, longWindowSize, signalWindowSize, seriesType, order);
        polygonProducer.sendMessage(data);
        return ResponseEntity.status(HttpStatus.OK).body("Polygon macd Data sent to Kafka for processing");
    }

    @GetMapping("/rsi")
    public ResponseEntity<String> getRsiData(
            @RequestParam String symbol,
            @RequestParam String timespan,
            @RequestParam boolean adjusted,
            @RequestParam int windowSize,
            @RequestParam String seriesType,
            @RequestParam String order) {
        String data = polygonService.getRsi(symbol, timespan, adjusted, windowSize, seriesType, order);
        polygonProducer.sendMessage(data);
        return ResponseEntity.status(HttpStatus.OK).body("Polygon rsi Data sent to Kafka for processing");
    }

    // Custom data retrieval endpoint
    @GetMapping("/custom")
    public ResponseEntity<String> getCustomData(
            @RequestParam String symbol,
            @RequestParam String customParameter) {
        String data = polygonService.getCustomData(symbol, customParameter);
        polygonProducer.sendMessage(data);
        return ResponseEntity.status(HttpStatus.OK).body("Polygon custom Data sent to Kafka for processing");
    }
}
package PortfolioOptimization.service1.Service;

import PortfolioOptimization.service1.client.AlphaVantageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
-This is the service layer. It handles the core logic.
-This is where the communication with the external APIs (AlphaVantage and Polygon API) happens.
-Acts as an intermediary between the controller layer and the client classes.
- These service classes use the client classes (AlphaVantageClient.java & PolygonClient.java) to make the actual HTTP
  requests to the external APIs.
*/

@Service
public class AlphaVantageService {

    @Autowired
    private AlphaVantageClient alphaVantageClient;

    public String getTimeSeriesIntraday(String symbol, String interval, String adjusted, String extendedHours, String month, String outputsize, String datatype) {
        return alphaVantageClient.getTimeSeriesIntraday(symbol, interval, adjusted, extendedHours, month, outputsize, datatype);
    }

    public String getGlobalQuote(String symbol, String datatype) {
        return alphaVantageClient.getGlobalQuote(symbol, datatype);
    }

    public String searchSymbol(String keywords, String datatype) {
        return alphaVantageClient.searchSymbol(keywords, datatype);
    }

    public String getMarketStatus(String datatype) {
        return alphaVantageClient.getMarketStatus(datatype);
    }

    public String getMarketNewsSentiment(String tickers, String topics, String timeFrom, String sort, String limit, String datatype) {
        return alphaVantageClient.getMarketNewsSentiment(tickers, topics, timeFrom, sort, limit, datatype);
    }

    public String getTopGainersLosers(String datatype) {
        return alphaVantageClient.getTopGainersLosers(datatype);
    }

    public String getAnalyticsSlidingWindow(String symbols, String range, String ohlc, String interval, String windowSize, String calculations, String datatype) {
        return alphaVantageClient.getAnalyticsSlidingWindow(symbols, range, ohlc, interval, windowSize, calculations, datatype);
    }
}
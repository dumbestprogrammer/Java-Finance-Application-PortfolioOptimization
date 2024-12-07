package PortfolioOptimization.service1.Service;

import PortfolioOptimization.service1.client.PolygonClient;
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
public class PolygonService {

    @Autowired
    private PolygonClient polygonClient;

    public String getSma(String symbol, String timespan, boolean adjusted, int windowSize, String seriesType, String order)
    {
        return polygonClient.getSma(symbol, timespan, adjusted, windowSize, seriesType, order);
    }

    public String getEma(String symbol, String timespan, boolean adjusted, int windowSize, String seriesType, String order)
    {
        return polygonClient.getEma(symbol, timespan, adjusted, windowSize, seriesType, order);
    }

    public String getMacd(String symbol, String timespan, boolean adjusted, int shortWindowSize, int longWindowSize, int signalWindowSize, String seriesType, String order)
    {
        return polygonClient.getMacd(symbol, timespan, adjusted, shortWindowSize, longWindowSize, signalWindowSize, seriesType, order);
    }

    public String getRsi(String symbol, String timespan, boolean adjusted, int windowSize, String seriesType, String order)
    {
        return polygonClient.getRsi(symbol, timespan, adjusted, windowSize, seriesType, order);
    }

    // Custom data retrieval method
    public String getCustomData(String symbol, String customParameter)
    {
        return polygonClient.getCustomData(symbol, customParameter);
    }
}
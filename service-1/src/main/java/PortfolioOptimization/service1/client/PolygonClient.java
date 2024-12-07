package PortfolioOptimization.service1.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/*
So in this client folder I have two client classes 1 is AlphaVantageClient.java and 2 one is this class- PolygonClient.java.
The purpose of building these two classes is simple.
(i) These classes make HTTP requests to external APIs (two ext. APIs that I am using - Alpha Vantage and Polygon ).
(ii) Both these clients take parameters, build urls & make a REST API call to fetch the financial data.
(iii) These client layer classes are used by service layer to fetch the actual data from external services.
*/

@Component
public class PolygonClient {
    private final String apiKey;
    private final RestTemplate restTemplate;
    /*
    I used Rest Template here because I know the exact urls,I already know the addresses of these two external APIs.
    So in other words I can say that Rest Template is used to direct the HTTP requests to the known endpoints.
     */

    public PolygonClient(String apiKey) {
        this.apiKey = apiKey;
        this.restTemplate = new RestTemplate();
    }

    private String buildUrl(String endpoint, String... params) {
        StringBuilder url = new StringBuilder("https://api.polygon.io/v1/indicators/");
        url.append(endpoint).append("?");

        for (String param : params) {
            if (param != null && !param.isEmpty()) {
                url.append(param).append("&");
            }
        }

        url.append("apiKey=").append(apiKey);
        return url.toString();
    }

    public String getSma(String symbol, String timespan, boolean adjusted, int windowSize, String seriesType, String order) {
        String url = buildUrl("sma/" + symbol,
                "timespan=" + timespan,
                "adjusted=" + adjusted,
                "window=" + windowSize,
                "series_type=" + seriesType,
                "order=" + order);
        return restTemplate.getForObject(url, String.class);
    }

    public String getEma(String symbol, String timespan, boolean adjusted, int windowSize, String seriesType, String order) {
        String url = buildUrl("ema/" + symbol,
                "timespan=" + timespan,
                "adjusted=" + adjusted,
                "window=" + windowSize,
                "series_type=" + seriesType,
                "order=" + order);
        return restTemplate.getForObject(url, String.class);
    }

    public String getMacd(String symbol, String timespan, boolean adjusted, int shortWindowSize, int longWindowSize, int signalWindowSize, String seriesType, String order) {
        String url = buildUrl("macd/" + symbol,
                "timespan=" + timespan,
                "adjusted=" + adjusted,
                "short_window=" + shortWindowSize,
                "long_window=" + longWindowSize,
                "signal_window=" + signalWindowSize,
                "series_type=" + seriesType,
                "order=" + order);
        return restTemplate.getForObject(url, String.class);
    }

    public String getRsi(String symbol, String timespan, boolean adjusted, int windowSize, String seriesType, String order) {
        String url = buildUrl("rsi/" + symbol,
                "timespan=" + timespan,
                "adjusted=" + adjusted,
                "window=" + windowSize,
                "series_type=" + seriesType,
                "order=" + order);
        return restTemplate.getForObject(url, String.class);
    }

    // Placeholder for a custom data retrieval method
    public String getCustomData(String symbol, String customParameter) {
        String url = buildUrl("customEndpoint/" + symbol,
                "customParameter=" + customParameter);
        return restTemplate.getForObject(url, String.class);
    }
}
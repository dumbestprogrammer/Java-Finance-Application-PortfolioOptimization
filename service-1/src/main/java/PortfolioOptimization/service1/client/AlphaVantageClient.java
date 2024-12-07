package PortfolioOptimization.service1.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


/*
So in this client folder I have two client classes 1 is This class i.e AlphaVantageClient.java and 2 one is PolygonClient.java.
The purpose of building these two classes is simple.
(i) These classes make HTTP requests to external APIs (two ext. APIs that I am using - Alpha Vantage and Polygon ).
(ii) Both these clients take parameters, build urls & make a REST API call to fetch the financial data.
(iii) These client layer classes are used by service layer to fetch the actual data from external services.
*/



@Component
public class AlphaVantageClient {
    private final String intradayApiKey;
    private final String globalQuoteApiKey;
    private final String symbolSearchApiKey;
    private final String marketStatusApiKey;
    private final String newsSentimentApiKey;
    private final String topGainersLosersApiKey;
    private final String advancedAnalyticsApiKey;
    private final RestTemplate restTemplate;
    /*
    I used Rest Template here because I know the exact urls,I already know the addresses of these two external APIs.
    So in other words I can say that Rest Template is used to direct the HTTP requests to the known endpoints.
    */



    public AlphaVantageClient(String intradayApiKey, String globalQuoteApiKey, String symbolSearchApiKey, String marketStatusApiKey, String newsSentimentApiKey, String topGainersLosersApiKey, String advancedAnalyticsApiKey)
    {
        this.intradayApiKey = intradayApiKey;
        this.globalQuoteApiKey = globalQuoteApiKey;
        this.symbolSearchApiKey = symbolSearchApiKey;
        this.marketStatusApiKey = marketStatusApiKey;
        this.newsSentimentApiKey = newsSentimentApiKey;
        this.topGainersLosersApiKey = topGainersLosersApiKey;
        this.advancedAnalyticsApiKey = advancedAnalyticsApiKey;
        this.restTemplate = new RestTemplate();
    }

    public String getTimeSeriesIntraday(String symbol, String interval, String adjusted, String extendedHours, String month, String outputsize, String datatype)
    {
        StringBuilder url = new StringBuilder("https://www.alphavantage.co/query");
        url.append("?function=TIME_SERIES_INTRADAY")
                .append("&symbol=").append(symbol)
                .append("&interval=").append(interval)
                .append("&apikey=").append(intradayApiKey)
                .append("&adjusted=").append(adjusted)
                .append("&extended_hours=").append(extendedHours)
                .append("&outputsize=").append(outputsize)
                .append("&datatype=").append(datatype);

        if (month != null && !month.isEmpty()) {
            url.append("&month=").append(month);
        }

        return restTemplate.getForObject(url.toString(), String.class);
    }

    public String getGlobalQuote(String symbol, String datatype) {
        StringBuilder url = new StringBuilder("https://www.alphavantage.co/query");
        url.append("?function=GLOBAL_QUOTE")
                .append("&symbol=").append(symbol)
                .append("&apikey=").append(globalQuoteApiKey)
                .append("&datatype=").append(datatype);

        return restTemplate.getForObject(url.toString(), String.class);
    }

    public String searchSymbol(String keywords, String datatype) {
        StringBuilder url = new StringBuilder("https://www.alphavantage.co/query");
        url.append("?function=SYMBOL_SEARCH")
                .append("&keywords=").append(keywords)
                .append("&apikey=").append(symbolSearchApiKey)
                .append("&datatype=").append(datatype);

        return restTemplate.getForObject(url.toString(), String.class);
    }

    public String getMarketStatus(String datatype) {
        StringBuilder url = new StringBuilder("https://www.alphavantage.co/query");
        url.append("?function=MARKET_STATUS")
                .append("&apikey=").append(intradayApiKey)
                .append("&datatype=").append(datatype);

        return restTemplate.getForObject(url.toString(), String.class);
    }

    public String getMarketNewsSentiment(String tickers, String topics, String timeFrom, String sort, String limit, String datatype) {
        StringBuilder url = new StringBuilder("https://www.alphavantage.co/query");
        url.append("?function=NEWS_SENTIMENT")
                .append("&tickers=").append(tickers)
                .append("&topics=").append(topics)
                .append("&time_from=").append(timeFrom)
                .append("&sort=").append(sort)
                .append("&limit=").append(limit)
                .append("&apikey=").append(intradayApiKey)
                .append("&datatype=").append(datatype);

        return restTemplate.getForObject(url.toString(), String.class);
    }

    public String getTopGainersLosers(String datatype) {
        StringBuilder url = new StringBuilder("https://www.alphavantage.co/query");
        url.append("?function=TOP_GAINERS_LOSERS")
                .append("&apikey=").append(intradayApiKey)
                .append("&datatype=").append(datatype);

        return restTemplate.getForObject(url.toString(), String.class);
    }

    public String getAnalyticsSlidingWindow(String symbols, String range, String ohlc, String interval, String windowSize, String calculations, String datatype) {
        StringBuilder url = new StringBuilder("https://www.alphavantage.co/query");
        url.append("?function=ANALYTICS_SLIDING_WINDOW")
                .append("&SYMBOLS=").append(symbols)
                .append("&RANGE=").append(range)
                .append("&OHLC=").append(ohlc)
                .append("&INTERVAL=").append(interval)
                .append("&WINDOW_SIZE=").append(windowSize)
                .append("&CALCULATIONS=").append(calculations)
                .append("&apikey=").append(intradayApiKey)
                .append("&datatype=").append(datatype);

        return restTemplate.getForObject(url.toString(), String.class);
    }
}
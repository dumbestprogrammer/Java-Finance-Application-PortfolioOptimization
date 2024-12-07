package PortfolioOptimization.service1.configuration;

import PortfolioOptimization.service1.client.AlphaVantageClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//In this configuration class I am configuring the AlphaVantage class using the API keys so that everything works properly.
//The @Value mentioned here .....these values we give in the application properties.
@Configuration
public class AlphaVantageConfig {
    @Value("${alpha.vantage.intraday.api.key}")
    private String intradayApiKey;
    @Value("${alpha.vantage.global.quote.api.key}")
    private String globalQuoteApiKey;
    @Value("${alpha.vantage.symbol.search.api.key}")
    private String symbolSearchApiKey;

    @Value("${alpha.vantage.market.status.api.key}")
    private String marketStatusApiKey;

    @Value("${alpha.vantage.news.sentiment.api.key}")
    private String newsSentimentApiKey;

    @Value("${alpha.vantage.top.gainers.losers.api.key}")
    private String topGainersLosersApiKey;

    @Value("${alpha.vantage.advanced.analytics.api.key}")
    private String advancedAnalyticsApiKey;
    @Bean
    public AlphaVantageClient alphaVantageClient()
    {
        return new AlphaVantageClient
                (
                        intradayApiKey,
                        globalQuoteApiKey,
                        symbolSearchApiKey,
                        marketStatusApiKey,
                        newsSentimentApiKey,
                        topGainersLosersApiKey,
                        advancedAnalyticsApiKey
                );
    }
}
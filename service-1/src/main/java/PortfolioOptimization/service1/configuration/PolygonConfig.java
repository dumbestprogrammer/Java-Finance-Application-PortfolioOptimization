package PortfolioOptimization.service1.configuration;

import PortfolioOptimization.service1.client.PolygonClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//In this configuration class I am configuring the Polygon config class using the API keys so that everything works properly.
//The @Value mentioned here .....these values we give in the application properties.

@Configuration
public class PolygonConfig {
    @Value("${polygon.api.key}")
    private String apiKey;

    @Bean
    public PolygonClient polygonClient()
    {
        return new PolygonClient(apiKey);
    }

}
package PortfolioOptimization.service1.dto.alpha;

import java.time.LocalDateTime;

public class AlphaVantageMarketNewsSentimentDTO {
    private Long id;
    private String tickers;
    private String topics;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTickers() {
        return tickers;
    }

    public void setTickers(String tickers) {
        this.tickers = tickers;
    }

    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }

    public LocalDateTime getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(LocalDateTime timeFrom) {
        this.timeFrom = timeFrom;
    }

    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    private LocalDateTime timeFrom;
    private String sentiment;
    private String source;
    private String datatype;
}

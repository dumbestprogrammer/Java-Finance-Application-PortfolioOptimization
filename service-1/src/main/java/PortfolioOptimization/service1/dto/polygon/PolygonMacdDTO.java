package PortfolioOptimization.service1.dto.polygon;

public class PolygonMacdDTO {
    private Long id;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getHistogram() {
        return histogram;
    }

    public void setHistogram(float histogram) {
        this.histogram = histogram;
    }

    public float getSignal() {
        return signal;
    }

    public void setSignal(float signal) {
        this.signal = signal;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    private String symbol;
    private long timestamp;
    private float histogram;
    private float signal;
    private double value;
}

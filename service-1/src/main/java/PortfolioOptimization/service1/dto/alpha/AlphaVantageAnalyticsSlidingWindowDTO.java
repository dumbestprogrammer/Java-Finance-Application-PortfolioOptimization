package PortfolioOptimization.service1.dto.alpha;

public class AlphaVantageAnalyticsSlidingWindowDTO {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getOhlc() {
        return ohlc;
    }

    public void setOhlc(String ohlc) {
        this.ohlc = ohlc;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getWindowSize() {
        return windowSize;
    }

    public void setWindowSize(String windowSize) {
        this.windowSize = windowSize;
    }

    public String getCalculations() {
        return calculations;
    }

    public void setCalculations(String calculations) {
        this.calculations = calculations;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    private Long id;
    private String symbol;
    private String range;
    private String ohlc;
    private String interval;
    private String windowSize;
    private String calculations;
    private String datatype;
}

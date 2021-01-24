package com.barclays.stockmarketwatch.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class StockChartModel implements Serializable {

    @SerializedName("chart")
    @Expose
    private Chart chart;
    private final static long serialVersionUID = 6619780107261398958L;

    public Chart getChart() {
        return chart;
    }

    public void setChart(Chart chart) {
        this.chart = chart;
    }


    public class Adjclose implements Serializable {

        @SerializedName("adjclose")
        @Expose
        private List<Double> adjclose = null;
        private final static long serialVersionUID = -3847298497355643381L;

        public List<Double> getAdjclose() {
            return adjclose;
        }

        public void setAdjclose(List<Double> adjclose) {
            this.adjclose = adjclose;
        }

    }

    public class Chart implements Serializable {

        @SerializedName("result")
        @Expose
        private List<Result> result = null;
        @SerializedName("error")
        @Expose
        private Object error;
        private final static long serialVersionUID = 7765131708975583936L;

        public List<Result> getResult() {
            return result;
        }

        public void setResult(List<Result> result) {
            this.result = result;
        }

        public Object getError() {
            return error;
        }

        public void setError(Object error) {
            this.error = error;
        }

    }

    public class CurrentTradingPeriod implements Serializable {

        @SerializedName("pre")
        @Expose
        private Pre pre;
        @SerializedName("regular")
        @Expose
        private Regular regular;
        @SerializedName("post")
        @Expose
        private Post post;
        private final static long serialVersionUID = 9049411203348277486L;

        public Pre getPre() {
            return pre;
        }

        public void setPre(Pre pre) {
            this.pre = pre;
        }

        public Regular getRegular() {
            return regular;
        }

        public void setRegular(Regular regular) {
            this.regular = regular;
        }

        public Post getPost() {
            return post;
        }

        public void setPost(Post post) {
            this.post = post;
        }

    }

    public class Indicators implements Serializable {

        @SerializedName("quote")
        @Expose
        private List<Quote> quote = null;
        @SerializedName("adjclose")
        @Expose
        private List<Adjclose> adjclose = null;
        private final static long serialVersionUID = -4714257012715751574L;

        public List<Quote> getQuote() {
            return quote;
        }

        public void setQuote(List<Quote> quote) {
            this.quote = quote;
        }

        public List<Adjclose> getAdjclose() {
            return adjclose;
        }

        public void setAdjclose(List<Adjclose> adjclose) {
            this.adjclose = adjclose;
        }

    }

    public class Meta implements Serializable {

        @SerializedName("currency")
        @Expose
        private String currency;
        @SerializedName("symbol")
        @Expose
        private String symbol;
        @SerializedName("exchangeName")
        @Expose
        private String exchangeName;
        @SerializedName("instrumentType")
        @Expose
        private String instrumentType;
        @SerializedName("firstTradeDate")
        @Expose
        private Integer firstTradeDate;
        @SerializedName("regularMarketTime")
        @Expose
        private Integer regularMarketTime;
        @SerializedName("gmtoffset")
        @Expose
        private Integer gmtoffset;
        @SerializedName("timezone")
        @Expose
        private String timezone;
        @SerializedName("exchangeTimezoneName")
        @Expose
        private String exchangeTimezoneName;
        @SerializedName("regularMarketPrice")
        @Expose
        private Double regularMarketPrice;
        @SerializedName("chartPreviousClose")
        @Expose
        private Double chartPreviousClose;
        @SerializedName("priceHint")
        @Expose
        private Integer priceHint;
        @SerializedName("currentTradingPeriod")
        @Expose
        private CurrentTradingPeriod currentTradingPeriod;
        @SerializedName("dataGranularity")
        @Expose
        private String dataGranularity;
        @SerializedName("range")
        @Expose
        private String range;
        @SerializedName("validRanges")
        @Expose
        private List<String> validRanges = null;
        private final static long serialVersionUID = -4625397596221149799L;

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public String getExchangeName() {
            return exchangeName;
        }

        public void setExchangeName(String exchangeName) {
            this.exchangeName = exchangeName;
        }

        public String getInstrumentType() {
            return instrumentType;
        }

        public void setInstrumentType(String instrumentType) {
            this.instrumentType = instrumentType;
        }

        public Integer getFirstTradeDate() {
            return firstTradeDate;
        }

        public void setFirstTradeDate(Integer firstTradeDate) {
            this.firstTradeDate = firstTradeDate;
        }

        public Integer getRegularMarketTime() {
            return regularMarketTime;
        }

        public void setRegularMarketTime(Integer regularMarketTime) {
            this.regularMarketTime = regularMarketTime;
        }

        public Integer getGmtoffset() {
            return gmtoffset;
        }

        public void setGmtoffset(Integer gmtoffset) {
            this.gmtoffset = gmtoffset;
        }

        public String getTimezone() {
            return timezone;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }

        public String getExchangeTimezoneName() {
            return exchangeTimezoneName;
        }

        public void setExchangeTimezoneName(String exchangeTimezoneName) {
            this.exchangeTimezoneName = exchangeTimezoneName;
        }

        public Double getRegularMarketPrice() {
            return regularMarketPrice;
        }

        public void setRegularMarketPrice(Double regularMarketPrice) {
            this.regularMarketPrice = regularMarketPrice;
        }

        public Double getChartPreviousClose() {
            return chartPreviousClose;
        }

        public void setChartPreviousClose(Double chartPreviousClose) {
            this.chartPreviousClose = chartPreviousClose;
        }

        public Integer getPriceHint() {
            return priceHint;
        }

        public void setPriceHint(Integer priceHint) {
            this.priceHint = priceHint;
        }

        public CurrentTradingPeriod getCurrentTradingPeriod() {
            return currentTradingPeriod;
        }

        public void setCurrentTradingPeriod(CurrentTradingPeriod currentTradingPeriod) {
            this.currentTradingPeriod = currentTradingPeriod;
        }

        public String getDataGranularity() {
            return dataGranularity;
        }

        public void setDataGranularity(String dataGranularity) {
            this.dataGranularity = dataGranularity;
        }

        public String getRange() {
            return range;
        }

        public void setRange(String range) {
            this.range = range;
        }

        public List<String> getValidRanges() {
            return validRanges;
        }

        public void setValidRanges(List<String> validRanges) {
            this.validRanges = validRanges;
        }

    }

    public class Post implements Serializable {

        @SerializedName("timezone")
        @Expose
        private String timezone;
        @SerializedName("start")
        @Expose
        private Integer start;
        @SerializedName("end")
        @Expose
        private Integer end;
        @SerializedName("gmtoffset")
        @Expose
        private Integer gmtoffset;
        private final static long serialVersionUID = -2442532795954556113L;

        public String getTimezone() {
            return timezone;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }

        public Integer getStart() {
            return start;
        }

        public void setStart(Integer start) {
            this.start = start;
        }

        public Integer getEnd() {
            return end;
        }

        public void setEnd(Integer end) {
            this.end = end;
        }

        public Integer getGmtoffset() {
            return gmtoffset;
        }

        public void setGmtoffset(Integer gmtoffset) {
            this.gmtoffset = gmtoffset;
        }

    }

    public class Pre implements Serializable {

        @SerializedName("timezone")
        @Expose
        private String timezone;
        @SerializedName("start")
        @Expose
        private Integer start;
        @SerializedName("end")
        @Expose
        private Integer end;
        @SerializedName("gmtoffset")
        @Expose
        private Integer gmtoffset;
        private final static long serialVersionUID = -2555545347124002091L;

        public String getTimezone() {
            return timezone;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }

        public Integer getStart() {
            return start;
        }

        public void setStart(Integer start) {
            this.start = start;
        }

        public Integer getEnd() {
            return end;
        }

        public void setEnd(Integer end) {
            this.end = end;
        }

        public Integer getGmtoffset() {
            return gmtoffset;
        }

        public void setGmtoffset(Integer gmtoffset) {
            this.gmtoffset = gmtoffset;
        }

    }

    public class Quote implements Serializable {

        @SerializedName("volume")
        @Expose
        private List<Integer> volume = null;
        @SerializedName("open")
        @Expose
        private List<Double> open = null;
        @SerializedName("low")
        @Expose
        private List<Double> low = null;
        @SerializedName("close")
        @Expose
        private List<Double> close = null;
        @SerializedName("high")
        @Expose
        private List<Double> high = null;
        private final static long serialVersionUID = 1622547881070749018L;

        public List<Integer> getVolume() {
            return volume;
        }

        public void setVolume(List<Integer> volume) {
            this.volume = volume;
        }

        public List<Double> getOpen() {
            return open;
        }

        public void setOpen(List<Double> open) {
            this.open = open;
        }

        public List<Double> getLow() {
            return low;
        }

        public void setLow(List<Double> low) {
            this.low = low;
        }

        public List<Double> getClose() {
            return close;
        }

        public void setClose(List<Double> close) {
            this.close = close;
        }

        public List<Double> getHigh() {
            return high;
        }

        public void setHigh(List<Double> high) {
            this.high = high;
        }

    }

    public class Regular implements Serializable {

        @SerializedName("timezone")
        @Expose
        private String timezone;
        @SerializedName("start")
        @Expose
        private Integer start;
        @SerializedName("end")
        @Expose
        private Integer end;
        @SerializedName("gmtoffset")
        @Expose
        private Integer gmtoffset;
        private final static long serialVersionUID = -2600023044985942267L;

        public String getTimezone() {
            return timezone;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }

        public Integer getStart() {
            return start;
        }

        public void setStart(Integer start) {
            this.start = start;
        }

        public Integer getEnd() {
            return end;
        }

        public void setEnd(Integer end) {
            this.end = end;
        }

        public Integer getGmtoffset() {
            return gmtoffset;
        }

        public void setGmtoffset(Integer gmtoffset) {
            this.gmtoffset = gmtoffset;
        }

    }

    public class Result implements Serializable {

        @SerializedName("meta")
        @Expose
        private Meta meta;
        @SerializedName("timestamp")
        @Expose
        private List<Integer> timestamp = null;
        @SerializedName("indicators")
        @Expose
        private Indicators indicators;
        private final static long serialVersionUID = -3545468210190166489L;

        public Meta getMeta() {
            return meta;
        }

        public void setMeta(Meta meta) {
            this.meta = meta;
        }

        public List<Integer> getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(List<Integer> timestamp) {
            this.timestamp = timestamp;
        }

        public Indicators getIndicators() {
            return indicators;
        }

        public void setIndicators(Indicators indicators) {
            this.indicators = indicators;
        }

    }
}
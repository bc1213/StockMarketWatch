package com.barclays.stockmarketwatch.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StockAutoCompleteModel implements Serializable
{

    @SerializedName("explains")
    @Expose
    private List<Object> explains = null;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("quotes")
    @Expose
    private List<Quote> quotes = null;
    @SerializedName("news")
    @Expose
    private List<News> news = null;
    @SerializedName("nav")
    @Expose
    private List<Object> nav = null;
    @SerializedName("lists")
    @Expose
    private List<Object> lists = null;
    @SerializedName("researchReports")
    @Expose
    private List<Object> researchReports = null;
    @SerializedName("totalTime")
    @Expose
    private Integer totalTime;
    @SerializedName("timeTakenForQuotes")
    @Expose
    private Integer timeTakenForQuotes;
    @SerializedName("timeTakenForNews")
    @Expose
    private Integer timeTakenForNews;
    @SerializedName("timeTakenForAlgowatchlist")
    @Expose
    private Integer timeTakenForAlgowatchlist;
    @SerializedName("timeTakenForPredefinedScreener")
    @Expose
    private Integer timeTakenForPredefinedScreener;
    @SerializedName("timeTakenForCrunchbase")
    @Expose
    private Integer timeTakenForCrunchbase;
    @SerializedName("timeTakenForNav")
    @Expose
    private Integer timeTakenForNav;
    @SerializedName("timeTakenForResearchReports")
    @Expose
    private Integer timeTakenForResearchReports;
    private final static long serialVersionUID = -476026085724730127L;

    public List<Object> getExplains() {
        return explains;
    }

    public void setExplains(List<Object> explains) {
        this.explains = explains;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    public List<Object> getNav() {
        return nav;
    }

    public void setNav(List<Object> nav) {
        this.nav = nav;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public List<Object> getResearchReports() {
        return researchReports;
    }

    public void setResearchReports(List<Object> researchReports) {
        this.researchReports = researchReports;
    }

    public Integer getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Integer totalTime) {
        this.totalTime = totalTime;
    }

    public Integer getTimeTakenForQuotes() {
        return timeTakenForQuotes;
    }

    public void setTimeTakenForQuotes(Integer timeTakenForQuotes) {
        this.timeTakenForQuotes = timeTakenForQuotes;
    }

    public Integer getTimeTakenForNews() {
        return timeTakenForNews;
    }

    public void setTimeTakenForNews(Integer timeTakenForNews) {
        this.timeTakenForNews = timeTakenForNews;
    }

    public Integer getTimeTakenForAlgowatchlist() {
        return timeTakenForAlgowatchlist;
    }

    public void setTimeTakenForAlgowatchlist(Integer timeTakenForAlgowatchlist) {
        this.timeTakenForAlgowatchlist = timeTakenForAlgowatchlist;
    }

    public Integer getTimeTakenForPredefinedScreener() {
        return timeTakenForPredefinedScreener;
    }

    public void setTimeTakenForPredefinedScreener(Integer timeTakenForPredefinedScreener) {
        this.timeTakenForPredefinedScreener = timeTakenForPredefinedScreener;
    }

    public Integer getTimeTakenForCrunchbase() {
        return timeTakenForCrunchbase;
    }

    public void setTimeTakenForCrunchbase(Integer timeTakenForCrunchbase) {
        this.timeTakenForCrunchbase = timeTakenForCrunchbase;
    }

    public Integer getTimeTakenForNav() {
        return timeTakenForNav;
    }

    public void setTimeTakenForNav(Integer timeTakenForNav) {
        this.timeTakenForNav = timeTakenForNav;
    }

    public Integer getTimeTakenForResearchReports() {
        return timeTakenForResearchReports;
    }

    public void setTimeTakenForResearchReports(Integer timeTakenForResearchReports) {
        this.timeTakenForResearchReports = timeTakenForResearchReports;
    }

    public class News implements Serializable
    {

        @SerializedName("uuid")
        @Expose
        private String uuid;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("publisher")
        @Expose
        private String publisher;
        @SerializedName("link")
        @Expose
        private String link;
        @SerializedName("providerPublishTime")
        @Expose
        private Integer providerPublishTime;
        @SerializedName("type")
        @Expose
        private String type;
        private final static long serialVersionUID = -4125911887538981647L;

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPublisher() {
            return publisher;
        }

        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public Integer getProviderPublishTime() {
            return providerPublishTime;
        }

        public void setProviderPublishTime(Integer providerPublishTime) {
            this.providerPublishTime = providerPublishTime;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

    }

    public class Quote implements Serializable
    {

        @SerializedName("exchange")
        @Expose
        private String exchange;
        @SerializedName("shortname")
        @Expose
        private String shortname;
        @SerializedName("quoteType")
        @Expose
        private String quoteType;
        @SerializedName("symbol")
        @Expose
        private String symbol;
        @SerializedName("index")
        @Expose
        private String index;
        @SerializedName("score")
        @Expose
        private Double score;
        @SerializedName("typeDisp")
        @Expose
        private String typeDisp;
        @SerializedName("longname")
        @Expose
        private String longname;
        @SerializedName("isYahooFinance")
        @Expose
        private Boolean isYahooFinance;
        private final static long serialVersionUID = -2855591806435549192L;

        public String getExchange() {
            return exchange;
        }

        public void setExchange(String exchange) {
            this.exchange = exchange;
        }

        public String getShortname() {
            return shortname;
        }

        public void setShortname(String shortname) {
            this.shortname = shortname;
        }

        public String getQuoteType() {
            return quoteType;
        }

        public void setQuoteType(String quoteType) {
            this.quoteType = quoteType;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public Double getScore() {
            return score;
        }

        public void setScore(Double score) {
            this.score = score;
        }

        public String getTypeDisp() {
            return typeDisp;
        }

        public void setTypeDisp(String typeDisp) {
            this.typeDisp = typeDisp;
        }

        public String getLongname() {
            return longname;
        }

        public void setLongname(String longname) {
            this.longname = longname;
        }

        public Boolean getIsYahooFinance() {
            return isYahooFinance;
        }

        public void setIsYahooFinance(Boolean isYahooFinance) {
            this.isYahooFinance = isYahooFinance;
        }

    }

}
package com.barclays.stockmarketwatch.model;


import com.barclays.stockmarketwatch.di.DaggerApiComponent;

import javax.inject.Inject;

import io.reactivex.Single;


public class StockService {

    private static StockService instance;

    @Inject
    public StockApi api;

    private StockService() {
        DaggerApiComponent.create().inject(this);
    }

    public static StockService getInstance() {
        if (instance == null) {
            instance = new StockService();
        }
        return instance;
    }

    public Single<StockAutoCompleteModel> getStockSuggestions(String searchText) {
        return api.getStockNameSuggestions(searchText);
    }

    public Single<StockChartModel> getStockDetails(String interval, String symbol, String range) {
        return api.getStockChartDetails(interval, symbol, range);
    }
}

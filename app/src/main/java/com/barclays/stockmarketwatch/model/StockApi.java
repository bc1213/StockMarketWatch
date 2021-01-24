package com.barclays.stockmarketwatch.model;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface StockApi {

    @Headers({"x-rapidapi-key: 0a9dc58306msh08589f6b9fac4dcp15b822jsn251b80f76c5a", "x-rapidapi-host: apidojo-yahoo-finance-v1.p.rapidapi.com"})
    @GET("/auto-complete")
    Single<StockAutoCompleteModel> getStockNameSuggestions(@Query("q") String text);


    @Headers({"x-rapidapi-key: 0a9dc58306msh08589f6b9fac4dcp15b822jsn251b80f76c5a", "x-rapidapi-host: apidojo-yahoo-finance-v1.p.rapidapi.com"})
    @GET("/stock/v2/get-chart")
    Single<StockChartModel> getStockChartDetails(@Query("interval") String interval,
                                                 @Query("symbol") String symbol,
                                                 @Query("range") String range);

    @GET
    Single<Object> getObject(@Url String url);
}

package com.barclays.stockmarketwatch.di;

import com.barclays.stockmarketwatch.BuildConfig;
import com.barclays.stockmarketwatch.model.StockApi;
import com.barclays.stockmarketwatch.model.StockService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {
    private static final String BASE_URL = BuildConfig.BASE_URL;

    @Provides
    public StockApi providerStockApi() {

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(StockApi.class);
    }

    @Provides
    public StockService provideStockService(){
        return StockService.getInstance();
    }


}

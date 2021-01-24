package com.barclays.stockmarketwatch.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.barclays.stockmarketwatch.di.DaggerApiComponent;
import com.barclays.stockmarketwatch.model.StockAutoCompleteModel;
import com.barclays.stockmarketwatch.model.StockChartModel;
import com.barclays.stockmarketwatch.model.StockService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class StockViewModel extends ViewModel {


    public MutableLiveData<StockAutoCompleteModel> stocks = new MutableLiveData<StockAutoCompleteModel>();
    public MutableLiveData<Boolean> stockLoadError = new MutableLiveData<Boolean>();
    public MutableLiveData<Boolean> loading = new MutableLiveData<Boolean>();

    public MutableLiveData<StockChartModel> stocksChartDetails = new MutableLiveData<StockChartModel>();



    @Inject
    public StockService stockService;

    private CompositeDisposable disposable = new CompositeDisposable();

    public void fetchAutoCompleteNames(String text) {
        fetchStockNames(text);
    }

    public void fetchStockChartDetails(String interval, String symbol, String range) {
        fetchChartDetails(interval, symbol, range);
    }
    public StockViewModel() {
        super();
        DaggerApiComponent.create().inject(this);
    }


    private void fetchStockNames(String searchText) {
        loading.setValue(true);
        disposable.add(
                stockService.getStockSuggestions(searchText)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<StockAutoCompleteModel>(){

                    @Override
                    public void onSuccess(@NonNull StockAutoCompleteModel stockAutoCompleteModels) {
                        stocks.setValue(stockAutoCompleteModels);
                        stockLoadError.setValue(false);
                        loading.setValue(false);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        stockLoadError.setValue(true);
                        loading.setValue(false);
                        e.printStackTrace();

                    }
                })

        );
    }

    private void fetchChartDetails(String interval, String symbol, String range) {
        disposable.add(
                stockService.getStockDetails(interval, symbol, range)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<StockChartModel>(){

                            @Override
                            public void onSuccess(@NonNull StockChartModel stockAutoCompleteModels) {
                                stocksChartDetails.setValue(stockAutoCompleteModels);
                                stockLoadError.setValue(false);
                                loading.setValue(false);
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {
                                stockLoadError.setValue(true);
                                loading.setValue(false);
                                e.printStackTrace();

                            }
                        })

        );
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}

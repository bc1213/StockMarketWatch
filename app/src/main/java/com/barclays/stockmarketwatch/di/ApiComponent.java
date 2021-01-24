package com.barclays.stockmarketwatch.di;


import com.barclays.stockmarketwatch.model.StockService;
import com.barclays.stockmarketwatch.viewmodel.StockViewModel;

import dagger.Component;

@Component(modules = {ApiModule.class})
public interface ApiComponent {

    void inject(StockService service);

    void inject(StockViewModel viewModel);
}

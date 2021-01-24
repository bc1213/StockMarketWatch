package com.barclays.stockmarketwatch.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.barclays.stockmarketwatch.R;
import com.barclays.stockmarketwatch.common.PLog;
import com.barclays.stockmarketwatch.core.db.StockMarketDataBase;
import com.barclays.stockmarketwatch.core.model.WatchListTable;
import com.barclays.stockmarketwatch.model.StockAutoCompleteModel;
import com.barclays.stockmarketwatch.model.StockChartModel;
import com.barclays.stockmarketwatch.viewmodel.StockViewModel;
import com.github.mikephil.charting.charts.LineChart;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textfield.TextInputEditText;
import com.jakewharton.rxbinding3.widget.RxTextView;
import com.jakewharton.rxbinding3.widget.TextViewTextChangeEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


public class HomeFragment extends Fragment implements StockAdapter.StockClickListener {

    private static final String TAG = HomeFragment.class.getSimpleName();

    @BindView(R.id.stockSearchText)
    TextInputEditText stockSearchText;

    @BindView(R.id.stocksList)
    RecyclerView stocksListRV;

    @BindView(R.id.list_error)
    TextView listError;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;


    private StockViewModel viewModel;
    private CompositeDisposable disposable = new CompositeDisposable();
    private StockAdapter stockAdapter;
    private List<StockAutoCompleteModel.Quote> stockList = new ArrayList<>();

    LineChart chart;
    TextView marketTime, currency, price, exchangeName;

    WatchListTable stockDetails = new WatchListTable();

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);

        viewModel = ViewModelProviders.of(requireActivity()).get(StockViewModel.class);
        stockAdapter = new StockAdapter(stockList, this);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        stocksListRV.setLayoutManager(mLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(),
                mLayoutManager.getOrientation());
        stocksListRV.addItemDecoration(dividerItemDecoration);
        stocksListRV.setItemAnimator(new DefaultItemAnimator());
        stocksListRV.setAdapter(stockAdapter);

        listError.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.INVISIBLE);

        observeModel();

        disposable.add(
                RxTextView.textChangeEvents(stockSearchText)
                        .skipInitialValue()
                        .debounce(300, TimeUnit.MILLISECONDS)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(searchQuery()));
    }

    private DisposableObserver<TextViewTextChangeEvent> searchQuery() {
        return new DisposableObserver<TextViewTextChangeEvent>() {
            @Override
            public void onNext(TextViewTextChangeEvent textViewTextChangeEvent) {
                Log.d(TAG, "search string: " + textViewTextChangeEvent.getText().toString());

                if (textViewTextChangeEvent.getText().toString().length() > 3) {
                    makeAPICall();
                }
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        };
    }

    private void makeAPICall() {
        progressBar.setVisibility(View.VISIBLE);
        viewModel.fetchAutoCompleteNames(stockSearchText.getText().toString());
    }

    private void observeModel() {
        viewModel.stocks.observe(this, stockNameModels -> {
            if (stockNameModels != null) {
                stockList.clear();
                for (StockAutoCompleteModel.Quote value : stockNameModels.getQuotes()) {
                    stockList.add(value);
                }
                stockAdapter.notifyDataSetChanged();
            }
        });

        viewModel.loading.observe(this, isError -> {
            if (isError != null) {
                listError.setVisibility(isError ? View.VISIBLE : View.GONE);
            }
        });

        viewModel.stockLoadError.observe(this, isLoading -> {
            if (isLoading != null) {
                progressBar.setVisibility(isLoading ? View.VISIBLE : View.GONE);

                if (isLoading) {
                    listError.setVisibility(View.GONE);
                    stocksListRV.setVisibility(View.GONE);
                }
            }
        });

        viewModel.stocksChartDetails.observe(this, stockChartModel -> {
            if (stockChartModel != null) {
                PLog.d(TAG, "Data Arrived");
                Util.updateStockGraph(stockChartModel, chart, getActivity());
                updateDetails(stockChartModel);
            }
        });
    }

    private void updateDetails(StockChartModel stockChartModel) {
        StockChartModel.Meta stock = stockChartModel.getChart().getResult().get(0).getMeta();
        marketTime.setText("Time: " + Util.getDateInMonthFormat_unix(stock.getRegularMarketTime() + stock.getGmtoffset()));
        price.setText("Price: " + stock.getRegularMarketPrice());
        currency.setText("Currency: " + stock.getCurrency());
        exchangeName.setText("Market: " + stock.getExchangeName());

        stockDetails.setStockPrice("" + stock.getRegularMarketPrice());
        stockDetails.setCurrency("" + stock.getCurrency());
        stockDetails.setStockMarket("" + stock.getExchangeName());
        stockDetails.setStockMarket("" + stock.getRegularMarketPrice());
    }


    @Override
    public void onStockClicked(String symbol) {
        PLog.d(TAG, "clikedSysemr " + symbol);
        viewModel.fetchStockChartDetails("1d", symbol, "5d");
        openSignOutDialog(symbol);
    }

    public void openSignOutDialog(String symbol) {
        View view = getLayoutInflater().inflate(R.layout.stockdetails_popup, null);
        final BottomSheetDialog dialog = new BottomSheetDialog(getContext());
        dialog.setContentView(view);

        chart = view.findViewById(R.id.chart);
        marketTime = view.findViewById(R.id.MarketTime);
        currency = view.findViewById(R.id.currecy);
        price = view.findViewById(R.id.price);
        exchangeName = view.findViewById(R.id.exchangeName);

        TextView stockName = view.findViewById(R.id.stockName);
        stockName.setText(symbol);

        WatchListTable table = StockMarketDataBase.getInstance().getWatchListTable().loadWatchListStatus(symbol);
        stockDetails.setStockSymbol(symbol);

        ImageView wishListIcon = view.findViewById(R.id.wishListIcon);
        wishListIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WatchListTable table = StockMarketDataBase.getInstance().getWatchListTable().loadWatchListStatus(symbol);
                if (table == null) {
                    StockMarketDataBase.getInstance().getWatchListTable().insertWatchList(stockDetails);
                    wishListIcon.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.ic_wishlist_sel));
                    Util.showSuccessToast(getActivity(), symbol + " is Added to Favourite !");
                } else {
                    StockMarketDataBase.getInstance().getWatchListTable().deleteWatchList(stockDetails);
                    wishListIcon.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.ic_wishlist_unsel));
                    Util.showInfoToast(getActivity(), symbol + " is removed from Favourite !");
                }
            }
        });

        wishListIcon.setImageDrawable(table != null ? getActivity().getResources().getDrawable(R.drawable.ic_wishlist_sel) :
                getActivity().getResources().getDrawable(R.drawable.ic_wishlist_unsel));

        Util.chartStyle(chart, getActivity());

        stockName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        dialog.show();
    }


}
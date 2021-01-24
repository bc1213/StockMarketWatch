package com.barclays.stockmarketwatch.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.barclays.stockmarketwatch.R;
import com.barclays.stockmarketwatch.core.db.StockMarketDataBase;
import com.barclays.stockmarketwatch.core.model.WatchListTable;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class WatchListFragment extends Fragment implements WatchListAdapter.WatchClickListener {


    private static final String TAG = HomeFragment.class.getSimpleName();

    @BindView(R.id.watchList)
    RecyclerView watchListRV;

    @BindView(R.id.list_error)
    TextView listError;

    @BindView(R.id.SwipeRefresh)
    SwipeRefreshLayout refreshLayout;

    private List<WatchListTable> watchListTables;
    private List<WatchListTable> watchListValue = new ArrayList<>();
    private WatchListAdapter watchListAdapter;

    public WatchListFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_watch_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        watchListTables = StockMarketDataBase.getInstance().getWatchListTable().getAllReports();

        watchListAdapter = new WatchListAdapter(watchListValue, this);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        watchListRV.setLayoutManager(mLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(),
                mLayoutManager.getOrientation());
        watchListRV.addItemDecoration(dividerItemDecoration);
        watchListRV.setItemAnimator(new DefaultItemAnimator());
        watchListRV.setAdapter(watchListAdapter);

        listError.setVisibility(watchListTables.size() > 0 ? View.GONE : View.VISIBLE);

        if (watchListTables != null) {
            watchListValue.clear();
            watchListValue.addAll(watchListTables);
            watchListAdapter.notifyDataSetChanged();
        }

        refreshLayout.setOnRefreshListener(() -> {
            watchListValue.clear();
            watchListTables = StockMarketDataBase.getInstance().getWatchListTable().getAllReports();
            watchListValue.addAll(watchListTables);
            watchListAdapter.notifyDataSetChanged();
            listError.setVisibility(watchListTables.size() > 0 ? View.GONE : View.VISIBLE);
            refreshLayout.setRefreshing(false);
        });
    }


    @Override
    public void onStockClicked(String symbol) {

    }
}
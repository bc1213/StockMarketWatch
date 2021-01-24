package com.barclays.stockmarketwatch.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.barclays.stockmarketwatch.R;
import com.barclays.stockmarketwatch.core.model.WatchListTable;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WatchListAdapter extends RecyclerView.Adapter<WatchListAdapter.StockListHolder> {

    private List<WatchListTable> stocksName;
    private WatchClickListener stockClickListener;

    public interface WatchClickListener extends Serializable {
        void onStockClicked(String symbol);
    }

    public WatchListAdapter(List<WatchListTable> stocks, WatchClickListener stockClickListener) {
        this.stocksName = stocks;
        this.stockClickListener = stockClickListener;
    }

    public void updateStockNames(List<WatchListTable> newStocks) {
        stocksName.clear();
        stocksName.addAll(newStocks);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StockListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stocklist, parent, false);
        return new StockListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StockListHolder holder, int position) {
        holder.bind(stocksName.get(position));
    }

    @Override
    public int getItemCount() {
        return stocksName.size();
    }

    class StockListHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.stockSymbol)
        TextView stockSymbol;

        @BindView(R.id.index)
        TextView stockIndex;

        @BindView(R.id.market)
        TextView stockMarket;

        @BindView(R.id.shortname)
        TextView stockShortName;

        @BindView(R.id.type)
        TextView stockType;

        @BindView(R.id.stockBox)
        RelativeLayout stockLayout;


        public StockListHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(WatchListTable stock) {
            stockSymbol.setText(stock.getStockSymbol());
            stockIndex.setText("" + stock.getStockPrice());
            stockMarket.setText(stock.getStockMarket());
            stockShortName.setText(stock.getStockName());
            stockType.setText(stock.getCurrency());

            stockLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    stockClickListener.onStockClicked(stock.getStockSymbol());
                }
            });
        }
    }


}
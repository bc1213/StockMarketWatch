package com.barclays.stockmarketwatch.core.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.barclays.stockmarketwatch.core.model.WatchListDao;
import com.barclays.stockmarketwatch.core.model.WatchListTable;


@Database(entities = WatchListTable.class, version = 1, exportSchema = false)
public abstract class StockMarketDataBase extends RoomDatabase {

    private static StockMarketDataBase INSTANCE;
    public static final String DATABASE_NAME = "stock_db";


    public static StockMarketDataBase initDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (StockMarketDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), StockMarketDataBase.class, DATABASE_NAME)
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public static StockMarketDataBase getInstance() {
        return INSTANCE;
    }

    public abstract WatchListDao getWatchListTable();


}

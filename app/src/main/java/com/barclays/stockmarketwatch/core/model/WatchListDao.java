package com.barclays.stockmarketwatch.core.model;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WatchListDao {

    @Insert
    void insertWatchList(WatchListTable watchListTable);

    @Delete
    void deleteWatchList(WatchListTable watchListTable);

    @Query("SELECT *FROM WatchListTable WHERE stockSymbol = :stockSymbol")
    WatchListTable loadWatchListStatus(String stockSymbol);

    @Query("SELECT * FROM WatchListTable")
    List<WatchListTable> getAllReports();

}

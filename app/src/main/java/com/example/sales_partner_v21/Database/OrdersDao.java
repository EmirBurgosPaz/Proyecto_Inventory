package com.example.sales_partner_v21.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface OrdersDao {
    @Insert
    void InsertNewOrder(Orders order);

    @Query("SELECT MAX(id) FROM orders")
    int getMaxID();

    @Query("SELECT * FROM orders WHERE status_id = 0")
    public List<Orders> getordersforComfirm();


    @Query("SELECT * FROM orders")
    public List<Orders> getAllorders();

    @Query("SELECT date FROM orders")
    public List<String> getDates();

    @Query("SELECT date FROM orders WHERE date >= (:Year +'-01-01') " +
            "AND date <= (:Year +'-12-31')")
    public List<String> getDatesbyyear(String Year);

}

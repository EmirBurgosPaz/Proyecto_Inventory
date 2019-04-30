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

    @Query("SELECT * FROM orders WHERE date BETWEEN :initialDate AND :finalDate AND customer_id IN (:ids) AND status_id IN (:statuses);")
    List<Orders> getFilterOrders(String initialDate, String finalDate, int[] ids, int[] statuses);

    @Query("SELECT * FROM orders WHERE customer_id IN (:ids) AND status_id IN (:statuses)")
    List<Orders> getFilterOrdersByIDAndStatus(int[] ids, int[] statuses);

    @Query("SELECT customers.* FROM orders INNER JOIN customers ON customers.id = orders.customer_id WHERE orders.id = :order_id")
    Customers getCustomerFromOrderID(int order_id);

    @Query("SELECT order_status.* FROM orders INNER JOIN order_status ON orders.status_id = order_status.id WHERE orders.id = :order_id")
    OrderStatus getOrderStatusFromOrderID(int order_id);

    @Query("SELECT * FROM orders WHERE id = :order_id")
    Orders getOrderByID(int order_id);

    @Query("SELECT * FROM orders WHERE status_id = 0")
    public List<Orders> getordersforComfirm();


    @Query("SELECT * FROM orders")
    public List<Orders> getAllorders();

    @Query("SELECT date FROM orders")
    public List<String> getDates();

    @Query("SELECT * FROM orders WHERE date >= :date " +
            "AND date <= :date2")
    public List<Orders> getordersbydate(String date, String date2);

    @Query("SELECT SUM(p.price * oa.qty) FROM orders o " +
            " INNER JOIN order_assemblies oa  ON o.id = oa.order_id" +
            " INNER JOIN assemblies a ON a.id = oa.assembly_id  " +
            " INNER JOIN assembly_products ap ON ap.assembly_id = a.id " +
            " INNER JOIN products p ON ap.product_id = p.id " +
            " WHERE date >= :date AND date <= :date2 AND o.status_id = 4 OR o.status_id = 3")
    public int getCountbyDate(String date, String date2);
}

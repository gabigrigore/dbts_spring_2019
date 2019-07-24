package ro.dbts.repository;

import ro.dbts.model.Order;

import java.util.ArrayList;

public interface OrderRepository {
    void InitiateList();
    Order findOrderById(Integer id);
    ArrayList<Order> findAllOrders();

    void addOrder(Order o);

    void removeOrder(Integer id);
}

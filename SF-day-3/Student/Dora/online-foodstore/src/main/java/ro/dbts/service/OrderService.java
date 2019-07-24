package ro.dbts.service;

import ro.dbts.model.Order;

import java.util.ArrayList;

public interface OrderService {
    Order findOrderById(Integer id);

    ArrayList<Order> findAllOrders();

    void addOrder(Order o);

    void removeOrder(Integer id);
}

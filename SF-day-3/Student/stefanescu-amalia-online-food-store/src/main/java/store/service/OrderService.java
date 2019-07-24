package store.service;

import store.model.Order;

import java.util.List;

public interface OrderService {
    Order findOrderById(int id);
    List<Order> findAllOrders();
    void addOrder(Order o);
    void removeOrder(int id);
}

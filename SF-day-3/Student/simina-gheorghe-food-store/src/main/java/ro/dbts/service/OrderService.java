package ro.dbts.service;

import ro.dbts.model.Order;

import java.util.List;

public interface OrderService {
    Order findOrderById(int id);
    List<Order> findAllOrders();
    void addOrder(Order o);
    void removeOrder(int id);
    void setOrders(List<Order> orders);
}

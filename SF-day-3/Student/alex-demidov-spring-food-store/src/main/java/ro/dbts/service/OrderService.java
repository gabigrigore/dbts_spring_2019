package ro.dbts.service;

import ro.dbts.model.Order;

import java.util.List;

public interface OrderService {

    Order findOrderByID(int id);
    List<Order> findAllOrders();
    void addOrder(Order order);
    void removerOrder(int id);
}

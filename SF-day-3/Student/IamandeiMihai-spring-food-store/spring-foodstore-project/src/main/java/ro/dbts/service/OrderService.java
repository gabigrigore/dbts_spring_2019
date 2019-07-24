package ro.dbts.service;

import ro.dbts.model.Order;

import java.util.List;

public interface OrderService {
    Order findOrderById(Integer id);

    List<Order> findAllOrders();

    void addOrder(Order order);

    void removeOrder(Integer id);
}

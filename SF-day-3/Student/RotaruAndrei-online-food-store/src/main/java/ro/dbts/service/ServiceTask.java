package ro.dbts.service;

import ro.dbts.model.Order;

import java.util.List;

public interface ServiceTask {
    List<Order> findAllOrders();

    Order findOrderById(Integer id);

    void addOrder(Integer id, String name);

    void deleteOrder(Integer id);
}

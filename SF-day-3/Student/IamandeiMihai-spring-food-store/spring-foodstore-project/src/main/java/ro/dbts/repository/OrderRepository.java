package ro.dbts.repository;

import ro.dbts.model.Order;

import java.util.List;

public interface OrderRepository {
    Order findOrderById(Integer id);

    List<Order> findAllOrders();

    void addOrder(Order order);

    void removeOrder(Integer id);
}

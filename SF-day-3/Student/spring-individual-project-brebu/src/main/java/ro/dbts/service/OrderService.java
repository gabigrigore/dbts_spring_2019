package ro.dbts.service;

import ro.dbts.model.Order;
import ro.dbts.repository.OrderRepository;

import java.util.List;

public interface OrderService {
    List<Order> findAllOrders();

    Order findOrderById(int id);

    void addOrderById(Order o);

    void removeOrderById(Order o);

    OrderRepository getOrderRepository();
}

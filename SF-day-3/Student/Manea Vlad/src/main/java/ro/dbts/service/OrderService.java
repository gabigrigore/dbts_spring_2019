package ro.dbts.service;

import ro.dbts.model.Order;

import java.util.List;

public interface OrderService {

    public List<Order> findAllOrders();

    public Order findOrderById(String id);

    public void addOrder(Order order);

    public void removeOrder(String id);
}

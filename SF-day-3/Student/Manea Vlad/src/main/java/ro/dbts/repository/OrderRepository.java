package ro.dbts.repository;

import ro.dbts.model.Order;

import java.util.List;

public interface OrderRepository {

    public List<Order> findAllOrders();

    public Order findOrderById(String id);

    public void addOrder(Order order);

    public void removeOrder(String id);

}

package ro.dbts.repository;

import ro.dbts.model.Order;

import java.util.List;

public interface OrderRepository {

    Order findOrderById(int id);

    List<Order> findAllOrders();

    void addOrder(Order o);

    void removeOrder(Order o);

    List<Order> getList();
}

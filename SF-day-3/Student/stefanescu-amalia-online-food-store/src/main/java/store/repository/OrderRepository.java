package store.repository;

import store.model.Order;

import java.util.List;

public interface OrderRepository {

    Order findOrderById(int id);
    List<Order> findAllOrders();
    void addOrder(Order o);
    void removeOrder(int id);

}

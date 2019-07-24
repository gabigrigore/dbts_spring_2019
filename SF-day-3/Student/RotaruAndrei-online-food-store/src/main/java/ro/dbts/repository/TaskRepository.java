package ro.dbts.repository;

import ro.dbts.model.Order;

import java.util.List;

public interface TaskRepository {
    List<Order> findAllOrders();

    Order findOrderById(Integer id);

    void addOrder(Integer id, String name);

    void deleteOrder(Integer id);
}

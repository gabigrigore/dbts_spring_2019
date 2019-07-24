package ro.dbts.repository;

import ro.dbts.model.Order;

import java.util.List;

public interface OrderRepository {

    Order findOrderByID(int id);
    List<Order> findAllOrders();
    void addOrder(Order order);
    void removerOrder(int id);


}

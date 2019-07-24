package ro.dbts.repository;

import ro.dbts.model.Order;

import java.util.List;

public interface OrderRepository {
    List<Order> findAllOrders();

    List<Order> findOrderById(long orderId);

    List<Order> addOrder (Order o);

    List<Order> removeOrder (long ordderId);

}

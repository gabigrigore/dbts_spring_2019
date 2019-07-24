package ro.dbts.service;

import ro.dbts.model.Order;

import java.util.List;

public interface OrderService{

    List<Order> findAllOrders();

    List<Order> findOrderById(long orderId);

    List<Order> addOrder (Order o);

    List<Order> removeOrder (long ordderId);
}

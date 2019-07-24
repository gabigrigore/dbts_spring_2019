package ro.task.service;

import java.util.List;

import ro.task.model.Order;

public interface OrderService {

	Order findOrderById(Integer id);

	List<Order> findAllOrders();

	void addOrder(Order o);

	void removeOrder(Order o);

}
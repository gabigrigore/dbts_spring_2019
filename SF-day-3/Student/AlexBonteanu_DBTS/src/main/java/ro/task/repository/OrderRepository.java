package ro.task.repository;

import java.util.List;

import ro.task.model.Order;

public interface OrderRepository {

	Order findOrderById(Integer id);

	List<Order> findAllOrders();

	void addOrder(Order o);

	void removeOrder(Order o);

}
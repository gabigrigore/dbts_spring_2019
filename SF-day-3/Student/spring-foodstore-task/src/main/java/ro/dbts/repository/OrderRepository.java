package ro.dbts.repository;

import java.util.List;

import ro.dbts.model.Order;

public interface OrderRepository {

	void addOrder(Order o);

	List<Order> findAllOrders();

	Order findOrderById(Integer id);

	void removeOrder(Integer id);

}
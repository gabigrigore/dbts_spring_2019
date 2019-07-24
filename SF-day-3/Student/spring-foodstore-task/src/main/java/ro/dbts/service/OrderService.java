package ro.dbts.service;

import java.util.List;

import ro.dbts.model.Order;

public interface OrderService {

	Order findOrderById(Integer id);

	List<Order> findAll();

	void removeOrder(Integer id);

	void addOrder(Order o);

}
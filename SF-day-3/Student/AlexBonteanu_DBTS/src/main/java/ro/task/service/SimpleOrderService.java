package ro.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.task.model.Order;
import ro.task.repository.OrderRepository;

@Service
public class SimpleOrderService implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public Order findOrderById(Integer id) {
		return orderRepository.findOrderById(id);
	}
	
	@Override
	public List<Order> findAllOrders() {
		return orderRepository.findAllOrders();
	}
	
	@Override
	public void addOrder(Order o) {
		orderRepository.addOrder(o);
	}
	
	@Override
	public void removeOrder(Order o) {
		orderRepository.removeOrder(o);
	}
}

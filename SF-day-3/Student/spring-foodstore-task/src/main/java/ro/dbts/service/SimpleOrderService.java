package ro.dbts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.dbts.model.Order;
import ro.dbts.repository.OrderRepository;

@Service("orderService")
public class SimpleOrderService implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Order findOrderById (Integer id) {
		return orderRepository.findOrderById(id);
	}
	
	@Override
	public List<Order> findAll() {
		return orderRepository.findAllOrders();
	}
	
	@Override
	public void removeOrder (Integer id) {
		orderRepository.removeOrder(id);
	}
	
	@Override
	public void addOrder (Order o) {
		orderRepository.addOrder(o);
	}
	
}

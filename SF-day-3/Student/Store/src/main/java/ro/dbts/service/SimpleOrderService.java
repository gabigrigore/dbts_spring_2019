package ro.dbts.service;

import java.util.List;

import ro.dbts.model.Order;
import ro.dbts.repository.OrderRepository;

public class SimpleOrderService implements OrderService {
private OrderRepository orderRepository;
	

	@Override
	public List<Order> findAll(){
		return orderRepository.findAll();
	}

	public SimpleOrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	
}

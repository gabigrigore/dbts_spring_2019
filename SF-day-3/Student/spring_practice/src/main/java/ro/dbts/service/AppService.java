package ro.dbts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.dbts.model.Order;
import ro.dbts.repository.AppRepository;

@Service("appService")
public class AppService {
	
	@Autowired
	private AppRepository appRepository;
	
	public List<Order> createList(){
		return appRepository.createList();
	}
	
	public List<Order> findAllOrders(List<Order> orders){
		return appRepository.findAllOrders(orders);
	}
	
	public Order findOrderById(List<Order> orders, double order_id) {
		return appRepository.findOrderById(orders, order_id);
	}
	
	public List<Order> addOrder(List<Order> orders, Order new_order) {
		return appRepository.addOrder(orders, new_order);
	}
	
	public void removeOrder(List<Order> orders, double id) {
		appRepository.removeOrder(orders, id);
	}

}

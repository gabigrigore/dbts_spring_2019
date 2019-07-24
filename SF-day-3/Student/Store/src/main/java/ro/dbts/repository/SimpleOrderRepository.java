package ro.dbts.repository;

import java.util.ArrayList;
import java.util.List;

import ro.dbts.model.Order;

public class SimpleOrderRepository implements OrderRepository {
	
	List<Order> orders = new ArrayList<>();
	@Override
	public List<Order> findAll() {
		
		
		Order order = new Order();
		order.setId(1);
		order.setName("First Order");
		order.setDestination("Chicago");
		
		Order order2 = new Order();
		order2.setId(2);
		order2.setName("Second Order");
		order2.setDestination("London");
		
		orders.add(order);
		orders.add(order2);
		return orders;
		
		
	}
	

}
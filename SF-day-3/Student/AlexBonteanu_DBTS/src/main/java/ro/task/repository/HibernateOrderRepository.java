package ro.task.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ro.task.model.Order;


@Repository
public class HibernateOrderRepository implements OrderRepository {
	@Override
	public Order findOrderById(Integer id) {
		Order o = new Order();
		o.setId(2);
		o.setName("Fish");
		return o;
	}
	
	@Override
	public List<Order> findAllOrders() {
		List<Order> list = new ArrayList<>();
		Order o = new Order();
		o.setId(2);
		o.setName("Fish");
		list.add(o);
		Order t = new Order();
		t.setId(6);
		t.setName("Pork");
		list.add(t);
		return list;
	}
	
	@Override
	public void addOrder(Order o) {
		System.out.println("Order Added");
	}
	
	@Override
	public void removeOrder(Order o) {
		System.out.println("Order Removed");
	}
}

package ro.dbts.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import ro.dbts.model.Order;


@Repository
public class HibernateOrderRepository implements OrderRepository {
	
	private List<Order> allOrders = new ArrayList<>();
	
	Order o1 = new Order(1, "bread");
	Order o2 = new Order(2, "milk");
	Order o3 = new Order(3, "juice");
	
	@Override
	public void addOrder (Order o) {
		allOrders.add(o);
	}
	
	@Override
	public List<Order> findAllOrders() {
		allOrders.add(o1);
		allOrders.add(o2);
		allOrders.add(o3);
		
		return allOrders;
	}
	
	@Override
	public Order findOrderById (Integer id) {
		for (Order o : allOrders) {
			if (o.getId() == id) {
				return o;
			}
		}
		return null;
	}
	
	@Override
	public void removeOrder (Integer id) {
		for (Order o : allOrders) {
			if (o.getId() == id) {
				allOrders.remove(o);
			}
		}
	}
	
}

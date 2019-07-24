package ro.dbts.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ro.dbts.model.Order;

@Repository("appRepository")
public class AppRepository {
	
	Order order1 = new Order(13041, 60.5f);
	Order order2 = new Order(18420, 122.6f);
	Order order3 = new Order(21073, 78.56f);
	
	public List<Order> createList(){
		List<Order> ordersList = new ArrayList<>();
		
		ordersList.add(order1);
		ordersList.add(order2);
		ordersList.add(order3);
		
		return ordersList;
	}
	
	public Order findOrderById(List<Order> orders, double order_id) {
		
		for (Order o : orders) {
			
			if(o.getOrder_id() == order_id) {
				return o;
			}
		}
		
		return null;
	}
	
	public List<Order> findAllOrders(List<Order> orders){
		
		return orders;
	}
	
	public List<Order> addOrder (List<Order> orders, Order new_order) {
		
		orders.add(new_order);
		
		return orders;
	}
	
	public void removeOrder (List<Order> orders, double id) {
		
		for (Order order : orders) {
			if (order.getOrder_id() == id) {
				System.out.println("Order " + order.getOrder_id() + " removed.");
				Order o = new Order(id, order.getValue());
				orders.remove(o);
			}
			
		}
		
		
	}
	
}

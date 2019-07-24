package ro.dbts.repository;

import org.springframework.stereotype.Repository;
import ro.dbts.model.Order;

import java.util.ArrayList;
import java.util.List;
@Repository("orderRepository")
public class HibernateOrderRepository implements OrderRepository {
    private List<Order> orders;


    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public Order findOrderById(int id) {
            for(Order order:orders){
                if(order.getId()==id){
                    return order;
                }
            }
            return null;
    }

    @Override
    public List<Order> findAllOrders() {
        return orders;
    }

    @Override
    public void addOrder(Order o) {
            orders.add(o);
            System.out.println("Added an order");
    }

    @Override
    public void removeOrder(int id) {
        for(Order order:orders){
            if(order.getId()==id){
                orders.remove(order);
                System.out.println("Removed Order");
            }
        }


    }
}

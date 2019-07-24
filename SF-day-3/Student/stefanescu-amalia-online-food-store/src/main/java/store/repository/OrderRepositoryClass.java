package store.repository;

import org.springframework.stereotype.Repository;
import store.model.Order;

import java.util.ArrayList;
import java.util.List;

@Repository("orderRepository")
public class OrderRepositoryClass implements OrderRepository {


    @Override
    public Order findOrderById(int id) {

        List<Order> orders = new ArrayList<>();

        Order o = new Order();
        o.setId(2);
        o.setName("Name2");

        orders.add(o);

        for (Order or : orders) {
            if (or.getId()==id) {
                return o;
            }
        }
        return null;
    }

    @Override
    public List<Order> findAllOrders() {
        List<Order> orders = new ArrayList<>();
        Order o = new Order();
        o.setId(1);
        o.setName("Name1");

        orders.add(o);

        return orders;
    }

    @Override
    public void addOrder(Order o) {

        List<Order> orders = new ArrayList<>();

        orders.add(o);

    }

    @Override
    public void removeOrder(int id) {

        List<Order> orders = new ArrayList<>();
        for (Order o : orders) {
            if (o.getId()==id) {
                orders.remove(o);
            }
        }

    }
}

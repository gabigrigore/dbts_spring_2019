package ro.dbts.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ro.dbts.model.Order;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HIbernateOrderRepository implements OrderRepository {

    @Value("${OrderDatabase}")
    private String OrderDatabase;

    @Override
    public List<Order> findAllOrders() {
        List<Order> orders = new ArrayList<>();
        Order order = new Order();
        order.setOrderId(464136);
        order.setDescription("order description text");
        orders.add(order);
        return orders;

    }

    @Override
    public List<Order> findOrderById(long orderId) {
        List<Order> orders = new ArrayList<>();
        Order order = new Order();
        order.setOrderId(152197);
        order.setDescription("another order description text");
        orders.add(order);
        return orders;
    }

    @Override
    public List<Order> addOrder(Order o) {
        List<Order> orders = new ArrayList<>();
        orders.add(o);
        return orders;
    }

    @Override
    public List<Order> removeOrder(long ordderId) {
        List<Order> orders = new ArrayList<>();
        return orders;
    }
}

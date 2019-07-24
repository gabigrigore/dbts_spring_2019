package ro.dbts.repository;

import org.springframework.stereotype.Repository;
import ro.dbts.model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class HibernateOrderRepository implements OrderRepository {

    List<Order> orders;

    public HibernateOrderRepository() {
        this.orders = new ArrayList<>();
        this.orders.add(new Order(1, "Pizza"));
        this.orders.add(new Order(2, "Burger"));
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public Order findOrderByID(int id) {
        return orders.stream().filter(order -> order.getId() == id).findFirst().get();
    }

    @Override
    public List<Order> findAllOrders() {
        List<Order> ordersCopy = new ArrayList<>();
        ordersCopy.addAll(orders);
        return ordersCopy;
    }

    @Override
    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public void removerOrder(int id) {
        orders.removeIf(order -> order.getId() == id);
    }
}

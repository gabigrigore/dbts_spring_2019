package ro.dbts.repository;

import org.springframework.stereotype.Repository;
import ro.dbts.model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository("orderRepository")
public class HibernateOrderRepository implements OrderRepository {

    private ArrayList<Order> orders = new ArrayList<>();

    @Override
    public Order findOrderById(Integer id) {

        for (Order order : orders) {
            if (Objects.equals(order.getId(), id)) {
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
    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public void removeOrder(Integer id) {
        for (Order order : orders) {
            if (Objects.equals(order.getId(), id)) {
                orders.remove(order);
                break;
            }
        }
    }
}

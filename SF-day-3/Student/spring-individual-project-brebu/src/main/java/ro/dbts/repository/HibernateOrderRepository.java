package ro.dbts.repository;

import org.springframework.stereotype.Repository;
import ro.dbts.model.Order;

import java.util.ArrayList;
import java.util.List;

@Repository("orderRepository")
public class HibernateOrderRepository implements OrderRepository {

    private List<Order> list;

    @Override
    public List<Order> getList() {
        return list;
    }

    @Override
    public Order findOrderById(int id) {
        for (Order o : list) {
            if (o.getId() == id) {
                return o;
            }
        }
        return null;
    }

    @Override
    public List<Order> findAllOrders() {
        list = new ArrayList<>();
        list.add(new Order(1, "Order 1"));
        list.add(new Order(2, "Order 2"));
        list.add(new Order(3, "Order 3"));
        list.add(new Order(4, "Order 4"));
        return list;
    }

    @Override
    public void addOrder(Order o) {
        list.add(o);
    }

    @Override
    public void removeOrder(Order o) {
        list.remove(o);
    }

}

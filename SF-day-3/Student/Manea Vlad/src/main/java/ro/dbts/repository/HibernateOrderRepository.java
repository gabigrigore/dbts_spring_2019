package ro.dbts.repository;

import org.springframework.stereotype.Repository;
import ro.dbts.model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository("orderRepository")
public class HibernateOrderRepository implements OrderRepository {

    List<Order> orders;

    public HibernateOrderRepository()
    {
        orders = new ArrayList<>();
    }

    public List<Order> findAllOrders()
    {
        return orders;
    }

    public Order findOrderById(String id)
    {
        List <Order>copyOrders = orders;
        copyOrders = copyOrders.stream().filter(p->(p.getId()).equals(id)).collect(Collectors.toList());
        return copyOrders.get(0);
    }

    public void addOrder(Order order)
    {
        orders.add(order);
    }

    public void removeOrder(String id)
    {
        orders = orders.stream().filter(p->!(p.getId()).equals(id)).collect(Collectors.toList());
    }

}

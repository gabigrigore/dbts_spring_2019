package store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import store.model.Order;
import store.repository.OrderRepository;

import java.util.List;

@Service("orderService")
public class OrderServiceClass implements OrderService {

    private OrderRepository orderRepository;

    private Order order;


    @Autowired
    public OrderServiceClass(OrderRepository orderRepository, @Qualifier("specialOrder") Order order) {
        this.orderRepository = orderRepository;
        this.order = order;
        System.out.println("Found the order " + order);
    }

    @Override
    public Order findOrderById(int id) {
        return orderRepository.findOrderById(id);
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAllOrders();
    }

    @Override
    public void addOrder(Order o) {
        orderRepository.addOrder(o);
    }

    @Override
    public void removeOrder(int id) {
        orderRepository.removeOrder(id);
    }
}

package ro.dbts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.dbts.model.Order;
import ro.dbts.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("orderService")
public class SimpleOrderService implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAllOrders()
    {
        return orderRepository.findAllOrders();
    }

    public Order findOrderById(String id)
    {
        return orderRepository.findOrderById(id);
    }

    public void addOrder(Order order)
    {
        orderRepository.addOrder(order);
    }

    public void removeOrder(String id)
    {
        orderRepository.removeOrder(id);
    }

}

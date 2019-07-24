package ro.dbts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.dbts.model.Order;
import ro.dbts.repository.OrderRepository;

import java.util.List;

@Service("orderService")
public class SimpleOrderService implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order findOrderById(Integer id) {
        return orderRepository.findOrderById(id);
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAllOrders();
    }

    @Override
    public void addOrder(Order order) {
        orderRepository.addOrder(order);
    }

    @Override
    public void removeOrder(Integer id) {
        orderRepository.removeOrder(id);
    }



}

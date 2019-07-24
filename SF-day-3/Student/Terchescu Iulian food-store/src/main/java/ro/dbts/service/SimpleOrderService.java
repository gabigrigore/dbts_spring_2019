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
    public List<Order> findAllOrders() {
        return orderRepository.findAllOrders();
    }

    @Override
    public List<Order> findOrderById(long orderId) {
        return null;
    }

    @Override
    public List<Order> addOrder(Order o) {
        return null;
    }

    @Override
    public List<Order> removeOrder(long ordderId) {
        return null;
    }
}

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

    public OrderRepository getOrderRepository() {
        return orderRepository;
    }

    @Override
    public List<Order> findAllOrders(){
        return orderRepository.findAllOrders();
    }

    @Override
    public Order findOrderById(int id){
        return orderRepository.findOrderById(id);
    }

    @Override
    public void addOrderById(Order o){
        orderRepository.addOrder(o);
    }

    @Override
    public void removeOrderById(Order o){
        orderRepository.removeOrder(o);
    }

}

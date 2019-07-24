package ro.dbts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.dbts.model.Order;
import ro.dbts.repository.OrderRepository;

import java.util.List;

@Service("orderService")
public class SimpleOrderService implements OrderService{
    @Autowired
    private OrderRepository orderRepository;

    public Order findOrderById(int id){return orderRepository.findOrderById(id);}
    public List<Order> findAllOrders(){return orderRepository.findAllOrders();}
    public void addOrder(Order o){orderRepository.addOrder(o);}
    public void removeOrder(int id){orderRepository.removeOrder(id);}
    public void setOrders(List<Order> orders){orderRepository.setOrders(orders);}
}

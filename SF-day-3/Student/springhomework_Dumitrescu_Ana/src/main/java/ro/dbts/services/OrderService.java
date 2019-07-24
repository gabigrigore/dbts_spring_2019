package ro.dbts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.dbts.models.Orderh;
import ro.dbts.repositories.OrderRepository;

import java.util.List;

@Service("orderService")
public class OrderService implements OrderServiceInterface{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Orderh> findAll() {

        return orderRepository.findAllOrders();
    }

    @Override
    public Orderh findOrderById(int id ) {

        return orderRepository.findOrderById(id);
    }


    @Override
    public void addOrder(int id, String name) {
        orderRepository.addOrder(id, name);
    }

    @Override
    public void removeOrder(int id){
        orderRepository.removeOrder(id);
    }
}

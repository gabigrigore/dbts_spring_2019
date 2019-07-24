package ro.dbts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.dbts.model.Order;
import ro.dbts.repository.HibernateOrderRepository;

import java.util.ArrayList;
@Service("orderService")
public class SimpleOrderService implements OrderService {
    @Autowired
    private HibernateOrderRepository or;

    public void InitiateList(){
        or.InitiateList();
    }
    public Order findOrderById(Integer id){
        return or.findOrderById(id);
    }
    public ArrayList<Order> findAllOrders(){
        return or.findAllOrders();
    }
    public void addOrder(Order o){
        or.addOrder(o);
    }
    public void removeOrder(Integer id){
        or.removeOrder(id);
    }

}

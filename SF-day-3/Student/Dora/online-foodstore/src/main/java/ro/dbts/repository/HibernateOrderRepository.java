package ro.dbts.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ro.dbts.model.Order;

import java.util.ArrayList;
import java.util.Iterator;
@Repository("orderRepository")
public class HibernateOrderRepository implements OrderRepository {

    @Value("${id1}")
    private Integer id1;
    @Value("${id2}")
    private Integer id2;
    @Value("${name1}")
    private String name1;
    @Value("${name2}")
    private String name2;

    ArrayList<Order> orders = new ArrayList<Order>();

    public void InitiateList(){
        addOrder(new Order(id1, name1));
        addOrder(new Order(id2, name2));
    }

    public Order findOrderById(Integer id){
        Iterator<Order> it = orders.iterator();
        Order currentObj;
        while(it.hasNext()){
            currentObj = it.next();
            if (currentObj.getId().equals(id)){
                return currentObj;
            }
        }
        return null;
    }

    public ArrayList<Order> findAllOrders(){
        return orders;
    }
    public void addOrder(Order o){
        orders.add(o);
    }
    public void removeOrder(Integer id){
        Iterator<Order> it = orders.iterator();
        Order currentObj;
        while(it.hasNext()){
            currentObj = it.next();
            if (currentObj.getId().equals(id)){
                orders.remove(currentObj);
            }
        }
    }
}

package ro.dbts.repository;

import org.springframework.stereotype.Repository;
import ro.dbts.model.Order;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SimpleTaskRepository implements TaskRepository {

    private List<Order> orders = new ArrayList<>();


    public SimpleTaskRepository() {
        orders.add(new Order(0,"pizza"));
        orders.add(new Order(1,"cola"));
        orders.add(new Order(2,"fast food"));
        orders.add(new Order(3,"salad"));
    }

    @Override
    public List<Order> findAllOrders(){
        return orders;
    }

    @Override
    public Order findOrderById(Integer id){
        for(int i=0; i < orders.size(); i++)
            if(orders.get(i).getId().compareTo(id) == 0)
                return orders.get(id);

        return null;
    }

    @Override
    public void addOrder(Integer id, String name){
        orders.add(new Order(id, name));
    }

    @Override
    public void deleteOrder(Integer id){

        for(int i=0; i < orders.size(); i++)
            if(orders.get(i).getId().compareTo(id) == 0)
                orders.remove(i);
    }
}

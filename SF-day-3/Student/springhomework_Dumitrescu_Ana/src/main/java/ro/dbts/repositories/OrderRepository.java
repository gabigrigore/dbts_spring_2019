package ro.dbts.repositories;

import org.springframework.stereotype.Repository;
import ro.dbts.models.Orderh;

import java.util.ArrayList;
import java.util.List;

@Repository("orderRepository")
public class OrderRepository implements OrderRepositoryInterface{

    private List<Orderh> orders = new ArrayList<>();

    @Override
    public Orderh findOrderById(int id) {
        Orderh order = new Orderh();
        order.setId(id);
        order.getId();
        return orders.get(order.getId());

    }

    @Override
    public List<Orderh> findAllOrders() {
        return orders;
    }

    @Override
    public void addOrder(int i, String name) {
        Orderh o = new Orderh();
        o.setId(i);
        o.setName(name);
        orders.add(o);
    }

    @Override
    public void removeOrder(int id) {
        orders.remove(id-1);
    }


}

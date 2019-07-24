package store.repository;

import store.objects.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FoodRepositoryMaker implements FoodRepository {


    private ArrayList<Order> orders;

    public FoodRepositoryMaker() {
        orders = new ArrayList<>();
    }

    @Override
    public List<Order> findAll() {
        return orders;
    }

    @Override
    public List<Order> findOrderById(final int order_id) {
        return orders.stream().filter(l -> l.getmId() == order_id).collect(Collectors.toList());
    }

    @Override
    public boolean addOrder(final Order newOrder) {
        return orders.add(newOrder);
    }

    @Override
    public boolean removeOrder(final Order oreder) {
        return orders.remove(oreder);
    }
}

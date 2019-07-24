package store.service;

import store.objects.Order;

import java.util.List;

public interface FoodService {
    List<Order> findAll();

    List<Order> findOrderById(int order_id);

    boolean addOrder(Order newOrder);

    boolean removeOrder(Order oreder);
}

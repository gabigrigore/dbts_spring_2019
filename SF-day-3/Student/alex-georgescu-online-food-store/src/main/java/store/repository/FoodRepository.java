package store.repository;

import store.objects.Order;

import java.util.List;

public interface FoodRepository {
    List<Order> findAll();

    Order findOrderById (int order_id);

    boolean addOrder(Order newOrder);

    boolean removeOrder (Order oreder_id);
}

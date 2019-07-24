package store.service;

import store.objects.Order;
import store.repository.FoodRepository;

import java.util.List;

public class SimpleFoodService implements FoodService {
    private FoodRepository orderRepository;

    public void setOrderRepository(FoodRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> findOrderById(final int order_id) {
        return orderRepository.findOrderById(order_id);
    }

    @Override
    public boolean addOrder(final Order newOrder) {
        return orderRepository.addOrder(newOrder);
    }

    @Override
    public boolean removeOrder(final Order oreder) {
        return orderRepository.removeOrder(oreder);
    }
}

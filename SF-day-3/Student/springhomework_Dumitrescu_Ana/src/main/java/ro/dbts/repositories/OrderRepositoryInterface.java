package ro.dbts.repositories;


import ro.dbts.models.Orderh;

import java.util.List;

public interface OrderRepositoryInterface {

    Orderh findOrderById(int id);

    List<Orderh> findAllOrders();

    public void addOrder(int i, String name);

    public void removeOrder(int id);
}

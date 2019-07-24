package ro.dbts.services;

import ro.dbts.models.Orderh;

import java.util.List;

public interface OrderServiceInterface {

    public List<Orderh> findAll();

    public Orderh findOrderById(int id );

    public void addOrder(int id, String name);

    public void removeOrder(int id);
}

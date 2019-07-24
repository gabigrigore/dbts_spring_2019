package ro.dbts.repository;

import java.util.List;

import ro.dbts.model.Order;

public interface OrderRepository {

	List<Order> findAll();

}
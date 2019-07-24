package ro.dbts.service;

import java.util.List;

import ro.dbts.model.Order;

public interface OrderService {

	List<Order> findAll();

}
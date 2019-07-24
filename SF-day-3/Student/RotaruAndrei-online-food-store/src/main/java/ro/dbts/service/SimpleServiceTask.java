package ro.dbts.service;

import jdk.nashorn.internal.objects.annotations.Constructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.dbts.model.Order;
import ro.dbts.repository.TaskRepository;

import java.util.List;

@Service
public class SimpleServiceTask implements ServiceTask {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Order> findAllOrders(){
        return taskRepository.findAllOrders();
    }

    @Override
    public Order findOrderById(Integer id){
        return taskRepository.findOrderById(id);
    }

    @Override
    public void addOrder(Integer id, String name){
        taskRepository.addOrder(id, name);
    }

    @Override
    public void deleteOrder(Integer id){
        taskRepository.deleteOrder(id);
    }
}

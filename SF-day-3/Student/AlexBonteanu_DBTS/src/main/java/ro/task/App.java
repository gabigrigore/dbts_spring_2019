package ro.task;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ro.task.model.Order;
import ro.task.service.OrderService;

public class App 
{
    public static void main( String[] args ) {
    	ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
    	OrderService orderService = appContext.getBean(OrderService.class);
    	orderService.findAllOrders().stream().forEach(System.out::println);
    	System.out.println(orderService.findOrderById(2));
    	orderService.addOrder(new Order());
    	orderService.removeOrder(new Order());
    }
}

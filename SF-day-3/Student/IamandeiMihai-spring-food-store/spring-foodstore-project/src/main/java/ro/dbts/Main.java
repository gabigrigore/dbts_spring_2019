package ro.dbts;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.dbts.model.Order;
import ro.dbts.service.OrderService;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        orderService.addOrder(new Order(1, "Order1"));
        orderService.addOrder(new Order(2, "Order2"));
        orderService.addOrder(new Order(3, "Order3"));
        orderService.addOrder(new Order(4, "Order4"));
        orderService.addOrder(new Order(5, "Order5"));
        orderService.addOrder(new Order(6, "Order6"));

        System.out.println("ORDERS LIST: " + orderService.findAllOrders());

        System.out.println("ORDER WITH ID 1: " + orderService.findOrderById(1));

        orderService.removeOrder(1);
        orderService.removeOrder(2);
        orderService.removeOrder(3);

        System.out.println("ORDERS AFTER REMOVE 1 2 3: " + orderService.findAllOrders());








    }
}

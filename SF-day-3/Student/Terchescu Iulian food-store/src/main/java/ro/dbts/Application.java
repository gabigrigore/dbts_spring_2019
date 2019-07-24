package ro.dbts;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ro.dbts.model.Order;
import ro.dbts.service.ApConfig;
import ro.dbts.service.OrderService;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        List<Order> orders = new ArrayList<>();
        Order order1 = new Order();
        order1.setOrderId(464136);
        order1.setDescription("order description text");
        orders.add(order1);

        Order order2 = new Order();
        order2.setOrderId(2316);
        order2.setDescription("another order description text");
        orders.add(order2);

        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ApConfig.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        System.out.println(orderService.findAllOrders().get(0).getOrderId());
        System.out.println(orderService.findAllOrders());
        


        //System.out.println(orderService.addOrder());

    }
}
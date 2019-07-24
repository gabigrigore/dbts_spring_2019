package ro.dbts;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ro.dbts.model.Order;
import ro.dbts.service.OrderService;

public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        orderService.addOrder(new Order(3, "Steak"));
        System.out.println(orderService.findAllOrders());

        System.out.println(orderService.findOrderByID(2));

        orderService.removerOrder(1);
        System.out.println(orderService.findAllOrders());

    }
}

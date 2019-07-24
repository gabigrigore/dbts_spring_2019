package ro.dbts;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.dbts.model.Order;
import ro.dbts.service.OrderService;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        List<Order> list = orderService.findAllOrders();

        System.out.println(list);

        orderService.removeOrderById(list.get(1));

        System.out.println(list);

        orderService.addOrderById(new Order(6,"Order 6"));

        System.out.println(list);


    }
}

package ro.dbts;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.dbts.services.OrderService;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);


        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        int n = 4;
        for(int i = 1; i < n; i++) {
            orderService.addOrder(i, "Pizza");

        }

        orderService.findAll();
        orderService.findOrderById(1);
        System.out.println(orderService.findOrderById(1));
        orderService.removeOrder(2);
        System.out.println(orderService.findAll());
    }
}


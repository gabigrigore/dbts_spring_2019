package ro.dbts;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ro.dbts.model.Order;
import ro.dbts.repository.HibernateOrderRepository;
import ro.dbts.service.OrderService;
import ro.dbts.service.SimpleOrderService;

public class Application {
    public static void main(String[] args) {
        Order order;

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        for(int i = 0; i < 5; i++)
        {
            order = new Order(String.valueOf(i), i*100);
            orderService.addOrder(order);
        }
        orderService.findAllOrders().stream().forEach(System.out::println);
        System.out.println(orderService.findOrderById(String.valueOf(2)));
        orderService.removeOrder(String.valueOf(1));
        System.out.println(orderService.findAllOrders());

    }
}

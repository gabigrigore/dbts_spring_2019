import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.dbts.model.Order;
import ro.dbts.service.OrderService;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        List<Order> orders = new ArrayList<>();
        Order o1 = new Order();
        o1.setId(1);
        o1.setName("Comanda1");
        Order o2 = new Order();
        o2.setId(2);
        o2.setName("Comanda2");
        Order o3 = new Order();
        o3.setId(3);
        o3.setName("Comanda3");

        orders.add(o1);
        orders.add(o2);
        orders.add(o3);

        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        orderService.setOrders(orders);
        System.out.println(orderService.findOrderById(2).getName());
        for(Order o: orderService.findAllOrders()){
            System.out.println(o.getName()+" "+o.getId());
        }
        Order o4 = new Order();
        o4.setName("Comanda 4");
        o4.setId(4);
        orderService.addOrder(o4);
        orderService.removeOrder(3);
        for(Order o: orderService.findAllOrders()){
            System.out.println(o.getName()+" "+o.getId());
        }
    }
}

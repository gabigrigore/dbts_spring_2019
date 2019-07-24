import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import store.model.Order;
import store.service.OrderService;

public class Application {
    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);


        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        System.out.println(orderService.findAllOrders().get(0).getName());

        System.out.println(orderService.findOrderById(2).getName());

        Order newOrder=new Order();
        newOrder.setId(3);
        newOrder.setName("Name3");

        orderService.addOrder(newOrder);

        orderService.addOrder(newOrder);
        orderService.removeOrder(3);
    }
}

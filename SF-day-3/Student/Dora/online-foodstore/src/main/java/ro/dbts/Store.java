package ro.dbts;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.dbts.service.OrderService;
import ro.dbts.service.SimpleOrderService;

public class Store {


    public static void main(String[] args){
        ApplicationContext appc = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService os = appc.getBean("orderService", SimpleOrderService.class);
        ((SimpleOrderService) os).InitiateList();
        System.out.println(os.findAllOrders());
        System.out.println(os.findOrderById(1));
        System.out.println(os.findOrderById(3)); // nu exista id 3
        os.removeOrder(1);
        System.out.println(os.findAllOrders());
    }
}

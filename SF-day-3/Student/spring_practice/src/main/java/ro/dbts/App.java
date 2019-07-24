package ro.dbts;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ro.dbts.model.Order;
import ro.dbts.service.AppService;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        
        AppService appService = applicationContext.getBean(AppService.class);
        
        List<Order> orders = appService.createList();
        
        System.out.println("----All orders----");
        System.out.println(appService.findAllOrders(orders));
        
        System.out.println("\n----Find order by Id----");
        System.out.println(appService.findOrderById(orders, 18420));
        
        System.out.println("\n----New orders list----");
        Order order = new Order (12345, 122.0f);
        System.out.println(appService.addOrder(orders, order));
        
        System.out.println("\n----Order removed----");
        appService.removeOrder(orders, 18420);
        
    }
}

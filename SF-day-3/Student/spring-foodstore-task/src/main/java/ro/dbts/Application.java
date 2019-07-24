package ro.dbts;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.dbts.service.OrderService;

public class Application {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext =
		        new AnnotationConfigApplicationContext(AppConfig.class);
		OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
		System.out.println("All Orders: " + orderService.findAll());
		System.out.println("Order with id = 2: " + orderService.findOrderById(2));
		System.out.println("Order with id = 5 (which does not exist): " + orderService.findOrderById(5));
		System.out.println("Removing order with id = 2...");
		orderService.removeOrder(2);
		System.out.println(orderService.findOrderById(2));

	}

}

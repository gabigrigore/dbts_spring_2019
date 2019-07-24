import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ro.dbts.model.Order;
import ro.dbts.service.OrderService;

public class Aplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext =
		        new ClassPathXmlApplicationContext("applicationContext.xml");
		    OrderService orderService = applicationContext.getBean("orderService", OrderService.class);  
		    
		    	
			    System.out.println("FIRST ORDER DETAILS: ");
			    System.out.println("Order1 id: " +orderService.findAll().get(0).getId());
			    System.out.println("Order1 name: " +orderService.findAll().get(0).getName());
			    System.out.println("Order1 destination: " +orderService.findAll().get(0).getDestination());
			   
			    System.out.println(orderService.toString());
			    System.out.println("Second ORDER DETAILS: ");
			    System.out.println("Order2 id: " +orderService.findAll().get(1).getId());
			    System.out.println("Order2 name: " +orderService.findAll().get(1).getName());
			    System.out.println("Order2 destination: " +orderService.findAll().get(1).getDestination());

			    
	}
	
}

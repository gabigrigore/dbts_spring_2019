package store.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import store.objects.Order;
import store.service.FoodService;

import java.time.LocalDate;

public class StoreMaker {

  public static void main(String[] args) {
    ApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("applicationContext.xml");

    FoodService service = applicationContext.getBean("orderService", FoodService.class);

    testOrder(service);
  }

  /**
   * Test for ServiceFood class
   * @param service
   */
  public static void testOrder(FoodService service) {
    service.addOrder(createOrder(1, "Pizza", "TODO", LocalDate.now()));
    service.addOrder(createOrder(2, "PizzaP", "TODO", LocalDate.now().minusYears(1)));
    service.addOrder(createOrder(3, "PizzaA", "TODO", LocalDate.now().plusYears(2)));


    System.out.println(service.findAll());

    System.out.println("----");

    System.out.println(service.findOrderById(1));

    System.out.println("----");

    System.out.println("Order 1: removed : " + service.removeOrder(service.findOrderById(1)));

    System.out.println("----");

    System.out.println(service.findAll());
  }

  /**
   * Method: create a new dummy order.
   * @param id
   * @param name
   * @param desc
   * @param date
   * @return
   */
  public static Order createOrder(int id, String name, String desc, LocalDate date) {
    Order dummy = new Order();
    dummy.setmId(id);
    dummy.setmName(name);
    dummy.setmDescription(desc);
    dummy.setmDate(date);
    return dummy;
  }
}

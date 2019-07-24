package ro.dbts;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.dbts.service.ServiceTask;
import ro.dbts.service.SimpleServiceTask;

public class Application {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        ServiceTask serviceTask = applicationContext.getBean(ServiceTask.class);

        System.out.println(serviceTask.findAllOrders());
        System.out.println(serviceTask.findOrderById(3));
        System.out.println(serviceTask.findOrderById(21));

        serviceTask.addOrder(23, "bread");
        System.out.println(serviceTask.findAllOrders());
        serviceTask.deleteOrder(3);
        System.out.println(serviceTask.findAllOrders());
    }
}

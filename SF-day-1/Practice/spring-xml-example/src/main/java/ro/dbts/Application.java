package ro.dbts;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ro.dbts.service.TaskService;

public class Application {

  public static void main(String[] args) {

    //TaskService taskService = new SimpleTaskService();

    ApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("applicationContext.xml");
    TaskService taskService = applicationContext.getBean("taskService", TaskService.class);

    System.out.println(taskService.findAll().get(0).getName());
  }
}

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.dbts.service.TaskService;

public class Application {

  public static void main(String[] args) {

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    TaskService taskService = applicationContext.getBean("taskService", TaskService.class);

    System.out.println(taskService.findAll().get(0).getName());
  }
}

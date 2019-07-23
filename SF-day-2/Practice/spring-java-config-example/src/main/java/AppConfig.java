import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.dbts.repository.HibernateTaskRepository;
import ro.dbts.repository.TaskRepository;
import ro.dbts.service.SimpleTaskService;
import ro.dbts.service.TaskService;

@Configuration
public class AppConfig {

  @Bean(name = "taskRepository")
  public TaskRepository getTaskRepository() {
    return new HibernateTaskRepository();
  }

  @Bean(name = "taskService")
  public TaskService getTaskService() {

    //setter injection
    SimpleTaskService taskService = new SimpleTaskService();
    taskService.setTaskRepository(getTaskRepository());
    return taskService;

    //constructor injection
    //return new SimpleTaskService(getTaskRepository());
  }
}

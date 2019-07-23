package ro.dbts.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ro.dbts.model.Task;

import java.util.ArrayList;
import java.util.List;

@Repository("taskRepository")
public class HibernateTaskRepository implements TaskRepository {

  @Value("${databaseUser}")
  private String databaseUser;

  @Override
  public List<Task> findAll() {

    System.out.println("database user: " + databaseUser);

    List<Task> tasks = new ArrayList<>();

    Task task = new Task();
    task.setName("First Task");
    task.setDescription("First Description");

    tasks.add(task);

    return tasks;
  }
}

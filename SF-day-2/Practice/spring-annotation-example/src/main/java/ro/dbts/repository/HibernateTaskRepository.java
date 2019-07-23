package ro.dbts.repository;

import org.springframework.stereotype.Repository;
import ro.dbts.model.Task;

import java.util.ArrayList;
import java.util.List;

@Repository("taskRepository")
public class HibernateTaskRepository implements TaskRepository {

  @Override
  public List<Task> findAll() {

      List<Task> tasks = new ArrayList<>();

      Task task = new Task();
      task.setName("First Task");
      task.setDescription("First Description");

      tasks.add(task);

      return tasks;
  }
}

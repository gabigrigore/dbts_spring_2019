package ro.dbts.repository;

import ro.dbts.model.Task;

import java.util.ArrayList;
import java.util.List;

public class HibernateTaskRepository implements TaskRepository {

  @Override
  public List<Task> findAll() {

    List<Task> tasks = new ArrayList<Task>();
    Task task = new Task();
    task.setName("Get water");
    task.setDescription("Bring water from the hibernate depo");
    tasks.add(task);

    return tasks;
  }
}

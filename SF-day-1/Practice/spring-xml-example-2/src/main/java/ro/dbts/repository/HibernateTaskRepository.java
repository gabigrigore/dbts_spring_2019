package ro.dbts.repository;

import ro.dbts.model.Task;

import java.util.ArrayList;
import java.util.List;

public class HibernateTaskRepository implements TaskRepository {

  @Override
  public List<Task> findAll() {

    List<Task> tasks = new ArrayList<Task>();
    Task task = new Task();
    task.setName("Write email");
    task.setDescription("Colleagues in London are waiting for your description.");
    tasks.add(task);

    return tasks;
  }
}

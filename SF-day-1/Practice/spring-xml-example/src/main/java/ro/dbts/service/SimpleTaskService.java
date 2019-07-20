package ro.dbts.service;

import ro.dbts.model.Task;
import ro.dbts.repository.TaskRepository;

import java.util.List;

public class SimpleTaskService implements TaskService {

  private TaskRepository taskRepository;  // = new HibernateTaskRepository();

  public void setTaskRepository(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  @Override
  public List<Task> findAll() {

    return taskRepository.findAll();
  }
}

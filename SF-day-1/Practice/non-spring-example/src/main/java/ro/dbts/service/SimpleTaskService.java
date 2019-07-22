package ro.dbts.service;

import ro.dbts.model.Task;
import ro.dbts.repository.HibernateTaskRepository;
import ro.dbts.repository.TaskRepository;

import java.util.List;

public class SimpleTaskService implements TaskService {

  private TaskRepository taskRepository = new HibernateTaskRepository();

  @Override
  public List<Task> findAll() {

    return taskRepository.findAll();
  }
}

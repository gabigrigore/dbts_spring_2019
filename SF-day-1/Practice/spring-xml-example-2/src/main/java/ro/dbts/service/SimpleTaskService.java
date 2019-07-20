package ro.dbts.service;

import ro.dbts.model.Task;
import ro.dbts.repository.TaskRepository;

import java.util.List;

public class SimpleTaskService implements TaskService {

  TaskRepository taskRepository;

  public SimpleTaskService(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  @Override
  public List<Task> findAll() {
    return taskRepository.findAll();
  }
}

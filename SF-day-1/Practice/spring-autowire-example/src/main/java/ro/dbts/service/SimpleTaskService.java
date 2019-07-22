package ro.dbts.service;

import ro.dbts.model.Task;
import ro.dbts.repository.HibernateTaskRepository;
import ro.dbts.repository.TaskRepository;

import java.util.List;

public class SimpleTaskService implements TaskService {

  private TaskRepository taskRepository = new HibernateTaskRepository();

  //used for XML constructor autowire
//  public SimpleTaskService(TaskRepository taskRepository) {
//    this.taskRepository = taskRepository;
//  }

  //used for byType & byName autowire (via setter)
  public void setTaskRepository(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  @Override
  public List<Task> findAll() {

    return taskRepository.findAll();
  }
}

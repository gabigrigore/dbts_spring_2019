package ro.dbts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.dbts.model.Task;
import ro.dbts.repository.TaskRepository;

import java.util.List;

@Service("taskService")
public class SimpleTaskService implements TaskService {

  @Autowired
  private TaskRepository taskRepository;

  /*@Autowired
  public SimpleTaskService(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }*/

/*@Autowired
  public void setTaskRepository(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }*/

  @Override
  public List<Task> findAll() {

    return taskRepository.findAll();
  }
}

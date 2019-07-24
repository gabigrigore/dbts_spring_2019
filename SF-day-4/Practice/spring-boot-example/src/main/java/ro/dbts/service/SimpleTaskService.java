package ro.dbts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.dbts.model.Task;
import ro.dbts.repository.TaskRepository;

import java.util.List;

@Service("taskService")
public class SimpleTaskService implements TaskService {

  @Autowired
  TaskRepository taskRepository;

  @Override
  public List<Task> findAll() {
    return taskRepository.findAll();
  }

  @Override
  public Task findFirstById(int id) {
    return taskRepository.findFirstById(id);
  }

  @Override
  public void removeTask(int id) {
    taskRepository.removeTask(id);
  }

  @Override
  public void addTask(Task task) {
    taskRepository.addTask(task);
  }
}

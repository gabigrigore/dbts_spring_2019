package ro.dbts.service;

import ro.dbts.model.Task;

import java.util.List;

public interface TaskService {
  List<Task> findAll();

  Task findFirstById(int id);

  void removeTask(int id);

  void addTask(Task task);
}

package ro.dbts.service;

import ro.dbts.model.Task;

import java.util.List;

public interface TaskService {
  List<Task> findAll();
}

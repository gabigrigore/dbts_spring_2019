package ro.dbts.repository;

import ro.dbts.model.Task;

import java.util.List;

public interface TaskRepository {
  List<Task> findAll();
}

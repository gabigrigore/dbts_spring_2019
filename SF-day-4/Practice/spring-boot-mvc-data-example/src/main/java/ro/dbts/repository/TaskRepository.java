package ro.dbts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.dbts.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}

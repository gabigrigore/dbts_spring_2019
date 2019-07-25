package ro.dbts.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.dbts.model.Task;
import ro.dbts.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class TaskController {

  @Autowired
  private TaskRepository taskRepository;

  @GetMapping("/tasks")
  public String findAll(Model model) {
    List<Task> tasks = taskRepository.findAll();
    model.addAttribute("tasks", tasks);
    return "listall";
  }

  @PostMapping("/add")
  @ResponseBody
  public Task addTask(@RequestBody Task task) {
    return taskRepository.saveAndFlush(task);
  }

  @PatchMapping("/update/{id}")
  @ResponseBody
  public Task update(@PathVariable Long id, @RequestBody Task task) {
    Task existingTask = taskRepository.getOne(id);
    existingTask.setName(task.getName());
    existingTask.setDescription(task.getDescription());
    return taskRepository.saveAndFlush(existingTask);
  }

  @GetMapping("/task/{id}")
  public Task get(@PathVariable Long id) {
    Optional<Task> task = taskRepository.findById(id);
    return task.orElse(null);
  }

  @DeleteMapping("/remove/{id}")
  @ResponseBody
  public Task remove(@PathVariable Long id) {
    Optional<Task> existingTask = taskRepository.findById(id);
    existingTask.ifPresent(t -> taskRepository.delete(t));
    return existingTask.orElse(null);
  }
}

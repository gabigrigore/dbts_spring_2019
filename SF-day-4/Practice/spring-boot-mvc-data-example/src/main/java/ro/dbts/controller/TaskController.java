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

  @GetMapping("/add")
  @ResponseBody
  public Task addTask(@RequestParam("id") Long id,
                      @RequestParam("name") String name,
                      @RequestParam("desc") String description) {
      return taskRepository.saveAndFlush(new Task(id, name, description));
  }

  @GetMapping("/update/{id}")
  public Task update(@PathVariable Long id,
                     @RequestParam("name") String name,
                     @RequestParam("desc") String desc) {
    Task existingTask = taskRepository.getOne(id);
    Task task = new Task(name, desc);
    BeanUtils.copyProperties(task, existingTask);
    return taskRepository.saveAndFlush(existingTask);
  }

  @GetMapping("/task/{id}")
  public Task get(@PathVariable Long id) {
    Optional<Task> task = taskRepository.findById(id);
    return task.orElse(null);
  }

  @GetMapping("/remove/{id}")
  public Task remove(@PathVariable Long id) {
    Optional<Task> existingTask = taskRepository.findById(id);
    existingTask.ifPresent(t -> taskRepository.delete(t));
    return existingTask.orElse(null);
  }
}

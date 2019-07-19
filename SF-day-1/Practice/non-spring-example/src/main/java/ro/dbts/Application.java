package ro.dbts;

import ro.dbts.service.SimpleTaskService;
import ro.dbts.service.TaskService;

public class Application {

  public static void main(String[] args) {

    TaskService taskService = new SimpleTaskService();

    System.out.println(taskService.findAll().get(0).getName());
  }
}

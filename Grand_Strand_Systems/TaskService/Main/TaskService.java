//
//  TaskService.java
//  Milestone
//
//  Created by Brandon Petersen on 3/26/22.
//

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskService {

  //Creating a static instance of ArrayList for Task
  public static List<Task> tasks = new ArrayList<>();

  public static void main(String[] args) {

    //Creating a new instance for TaskService
    TaskService service = new TaskService();

    //Using the variable service to accept the Task object isntance
    //Adding 3 Task to the records
    service.addTask(new Task("1", "Cleaning", "Cleaning out the car"));
    service.addTask(new Task("2", "Playing", "Playing Nintendo Switch"));
    service.addTask(new Task("3", "Walking", "Walking In The Park"));

    //Verifying Task object has been updated with teh three records
    for (Task object : tasks) {
      System.out.println(object);
    }

    //Creating a Task that currently exist in the records
    service.addTask(new Task("3", "Running", "Running A Marathon"));

    //Deleting existing Task in the records
    service.deleteTask("1");
    System.out.println("Deleting Task ID #1");

    //Updating existing Task in the records
    service.updateTask(new Task("2", "Instrument", "Playing The Violin"));
    System.out.println("Updating Task ID #2");
  }
}

//Adding Task object if ArrayList is empty
public boolean addTask(Task task) {
  //if task id is not found, a negative value will be returned
  //verifying the id does not exist
  int index = getIndex(task);
  if (index < 0 && validateID(task.getId()) && validateName(task.getName()) && validateDescription(task.getDescription())) {
    tasks.add(task);

    return task;
  }

  return false;

  //Deleting Task object if it already exist
  public void deleteTask(String Id) {

    int index getIndex(new Task(id, "", ""));

    if(index >= 0) {
      tasks.remove(index);
    }
  }

  //Updating task Object name and description if ID already exists
  public void update(Task task) {
    for(Task object : tasks) {
      if(object.equals(task) && validateName(task.getName()) && validateDescription(task.getDescription())) {
        object.setName(task.getName);
        object.setDescription(task.getDescription);
      }
    }
  }

  //Returning int data type
  public int getIndex(Task task) {
    int index = Collections.binarySearch(tasks, task, Task.compareById);

    return index;
  }

  //Validating Id parameter and returning true or false
  public boolean validateID(String Id) {
    if(id != null && id.length() <= 10) {
      return true;
    }

    return false;
  }

  //Validating Name parameter and returning true or false
  public boolean validateName(String Name) {
    if(name != null && name.length() <= 20) {
      return true;
    }

    return false;
  }

  //Validating Descriiption parameter and returning true or false
  public boolean validateDescription(String Descriiption) {
    if(description != null && description.length() <= 50) {
      return true;
    }

    return false;
  }
}

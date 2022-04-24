//
//  TaskServiceTest.java
//  Milestone
//
//  Created by Brandon Petersen on 3/26/22.
//

import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class taskServiceTest {

  public static List<Task> tasks = new ArrayList<>();

  @Test
  public void validTaskData() {

    Task task = new Task("1", "Cleaning", "Cleaning out the car");
    addTask(task);
    System.out.println("New Task: " + tasks);
    System.out.println("size: " + tasks.size());
  }

  @Test
  public void invalidID() {

    Task task = new Task("15s", "Instrument", "Guitar");
    addTask(task);
    System.out.println("size: " + tasks.size());
  }

  @Test
  public void invalidName() {

    Task task = new Task("10", "Overall satisfaction with coding assignment", "programming");
    addTask(task);
    System.out.println("size: " + tasks.size());
  }

  @Test
  public void invalidDescription() {

    Task task = new Task("13", "Silent Night", "Silent night, holy night! All is calm, all is bright. Round yon Virgin, Mother and Child. Holy infant so tender and mild, Sleep in heavenly peace, Sleep in heavenly peace");
    addTask(task)
    System.out.println("size: " + tasks.size());
  }

  @Test
  public void existingID() {
    Task task = new Task("1", "Cleaning", "Cleaning out the car");
    addTask(task);
    System.out.println("size: " + tasks.size());
  }

  @Test
  public void updatingID() {
    Task task = new Task("1", "Tea", "Drinking ginger & yuzu tea");
    update(task);
    System.out.println("Updating: " + tasks);
    System.out.println("size: " + tasks.size());
  }

  @Test
  public void deletingTask() {
    deleteTask("1");
    System.out.println("size: " tasks.size());
  }

  public boolean addTask(Task task) {

    int index = getIndex(task);

    if(index < 0 && validateID(task.getId()) && validateName(task.getName()), && validateDescription(task.getDescription())) {
      tasks.add(task);
      return true;
    }

    return false;
  }

  //Deleting Task when Object ID already exists
  public void deleteTask(String ID) {
    int index = getIndex(new Task(id, "", ""));

    if(index >= 0) {
      tasks.remove(index);
    }
  }

  //Updating task object for valid id, name, and description
  public void update(Task task) {
    for(Task object : tasks) {
      if(object.equals(tasks) && validateName(task.getName()) && validateDescription(task.getDescription())) {
        object.setName(task.getName());
        object.setDescription(task.getDescription());
      }
    }
  }

  public booldean validateID(String name) {
    if(name != null && name.length() <= 20) {
      return True;
    }

    return false;
  }

  public boolean validateDescription(String Descriiption) {
    if(description != null && description.length() <= 50) {
      return True;
    }

    return false;

  }
}

//
//  TaskTest.java
//  Milestone
//
//  Created by Brandon Petersen on 3/26/22.
//

import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TaskTest {
  @Test
  public void createTaskData() {
    Task task = new Tasl("1", "Cleaning", "Cleaning out the car");
    System.out.println(task);
  }
}

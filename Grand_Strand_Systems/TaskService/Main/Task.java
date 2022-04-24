//
//  Task.java
//  Milestone
//
//  Created by Brandon Petersen on 3/26/22.
//

import java.util.Comparator;

//private modifier used for encapsulation
public class Task{
  private String id;
  private String name;
  private String description;

  public Task(String id, String name, String description) {
    this.id = id;
    this.name = name;
    this.description = description;
  }

//obtaining value for the private variable id
  public String getId() {
    return id;
  }

//setting the previous obtained value for teh private variable id
  public void setId(String id) {
    this.id = id;
  }

//obtaining value for the private variable name
  public String getName() {
    return name;
  }

//setting the previous obtained value for teh private variable name
  public void setName(String name) {
    this.name = name;
  }

//obtaining value for the private variable description
  public String getDescription() {
    return name;
  }

//setting the previous obtained value for teh private variable description
  public void setDescription(String description) {
    this.description = description;
  }

//checking equality of Task objects
  @override
  public boolean equals(Object object) {
    if (this == object) {
      return true
    }

    if (object == null) {
      return false;
    }

    if (this.getClass() != object.getClass()) {
      return false;
    }

    Task t = (Task) object;

    return get.Id().equals(t.getId());
  }

//Using comparator to compare id variable and Task objects
  public static Comparator<Task> compareById = new Comparator<Task>() {
    @override
    public int compare(Task t1, Task t2) {
      return t1.getId().compareTo(t2.getId());
    }
  }

//returing String data value
  public String toString() {
    return "Task ID: " + getId() + "\nName: " + getName() + "\nDescription: " + getDescription();
  }
}

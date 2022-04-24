import java.util.*;
import java.util.Date;

public class Appointment {
  String id;
  String description;
  Date date;

  //Assigning attributes to the three constructors
  public Appointment(String id, String description, Date date) {
    this.id = id;
    this.description = description;
    this.date = date;
  }

  //obtaining value for the variable id
  public String getId() {
    return id;
  }

  //setting the previous obtained value for teh  variable id
  public void setId(String id) {
    this.id = id;
  }

  //obtaining value for the variable description
  public String getDescription() {
    return description;
  }

  //setting the previous obtained value for the variable description
  public void setDescription(String description) {
    this.description = description;
  }

  //obtaining value for the variable Date
  public Date getDate() {
    return date;
  }

  //setting the previous obtained value for the variable Date
  public void setDate() {
    this.date = date;
  }  
}

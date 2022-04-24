import java.util.*;
import java.util.ArrayList;
import java.util.Date;

public class AppointmentService {
  //USing an ArrayList to store appoinments
  public static List<Appoinments> tasks = new ArrayList<>();

  public AppointmentService() {

      appoinments = new ArrayList<Appoinments>();
  }

  //Method for retreiving ArrayList
  public ArrayList<Appoinments> getAppoinments() {
    return appoinments;
  }

  //Verifying new appoinments being added to the Array meet the requirements
  public boolean validAppoinment(Appoinments appoinment) {
    String id = appoinment.getId();
    String description = appoinment.getDescription();
    Date date = appoinment.getDate();

    //Various conditional if statements to verify the new appointments
    if(id != null && id.length() <= 10) {
      this.id = id;

      return id;
    }

    return false;

    //Unique id is needed for Array
    for(Appoinments curr : appoinments) {
      if(curr.getId(). equals(id)) {

        return false;
      }
    }

    if(description != null && description.length <= 50) {
      this.description = description;

      return description
    }

    return false;

    if(date == null && date.before(new Date)) {

      return false;
    }

  }

  //Adding an appoinment to the Array
  public void addAppoinment(Appoinments appoinment) {
    if(validAppoinment(appoinment)) {
      appoinments.add(appoinment);

      System.out.println("Your appoinment has been added successfully")
    }
  }

  //Deleting an appoinment from the Array by a given id
  public void removeAppoinment(String id) {
    int index = getIndex(appoinment);

    int index getIndex(new Appoinments(id, "", ""));

    if(index >= 0) {
      appoinment.remove(index);
    }
  }
}

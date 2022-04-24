import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class appoinmentServiceTest {

  public static List<Appoinments> appoinment = new ArrayList<>();

  @Test
  public void validAppoinmentData() {

    Appoinments appoinment = new Appoinments("1", "05/25/2022", "Getting regular eye check ups");
    addAppoinment(appoinment);
    System.out.println("New appoinment: " + appoinment);
    System.out.println("size: " + appoinment.size());
  }

  @Test
  public void invalidID() {

    Appoinments appoinment = new Appoinments("1534421912324445", "04/05/2022", "Taking car to get a oil change");
    addAppoinment(appoinment);
    System.out.println("size: " + appoinment.size());
  }


  @Test
  public void invalidDescription() {

    Appoinments appoinment = new Appoinments("13", "04/02/2022", "Silent night, holy night! All is calm, all is bright. Round yon Virgin, Mother and Child. Holy infant so tender and mild, Sleep in heavenly peace, Sleep in heavenly peace");
    addAppoinment(appoinment)
    System.out.println("size: " + appoinment.size());
  }

  @Test
  public void existingID() {
    Appoinments appoinment = new Appoinments("1", "08/28/2022", "Getting regular eye check ups");
    addAppoinment(appoinment);
    System.out.println("size: " + appoinment.size());
  }

  @Test
  public void updatingID() {
    Appoinments appoinment = new Appoinments("1", "06/27/2022", "Seeing violin teacher to practrice playing violin");
    update(appoinment);
    System.out.println("Updating: " + appoinment);
    System.out.println("size: " + appoinment.size());
  }

  @Test
  public void deletingAppointment() {
    deleteAppointment("1");
    System.out.println("size: " appoinment.size());
  }

  public boolean addAppoinment(Appoinments appoinment) {

    int index = getIndex(appoinment);

    if(index < 0 && validateID(appoinment.getId()) && validatedate(appoinment.getdate()), && validateDescription(appoinment.getDescription())) {
      appoinments.add(appoinment);
      return true;
    }

    return false;
  }

  //Deleting Appoinment when Object ID already exists
  public void deleteAppointment(String ID) {
    int index = getIndex(new Appoinment(id, "", ""));

    if(index >= 0) {
      appoinments.remove(index);
    }
  }

  //Updating appoinment object for valid id, date, and description
  public void update(Appoinments appoinment) {
    for(Appoinments object : appoinments) {
      if(object.equals(appoinments) && validatedate(appoinments.getdate()) && validateDescription(appoinments.getDescription())) {
        object.setdate(appoinment.getdate());
        object.setDescription(appoinment.getDescription());
      }
    }
  }

  public boolean validateDescription(String Descriiption) {
    if(description != null && description.length() <= 50) {
      return True;
    }

    return false;

  }
}

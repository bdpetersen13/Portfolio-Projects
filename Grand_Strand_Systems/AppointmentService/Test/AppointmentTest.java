import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AppoinmentTest {
  @Test
  public void createAppointmentData() {
    Appoinments appoinment = new Appoinment("1", "Eye", "Getting regular eye check ups");
    System.out.println(appoinment);
  }
}

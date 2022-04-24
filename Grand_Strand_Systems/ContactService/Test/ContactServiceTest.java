//
//  ContactServiceTest.java
//  Milestone
//
//  Created by Brandon Petersen on 3/18/22.
//

public class ContactServiceTest {
    public static void main(String[] args) {
      //Creating the contactService object
      ContactService contactService = new ContactService();

      //Creating new contacts to add to the ArrayList
      Contact contactOne = new Contact("ContactOne", "Brandon", "Petersen", "2405552799", "555 Riverdale RD, USA");
      Contact contactTwo = new Contact("ContactTwo", "Katie", "Goodman", "2405559827", "47 Richards DR, USA");

      //Adding the new contacts to the service
      if(contactService.addContact(contactOne)) {
        System.out.println("contactOne added successfully");
      }
      else {
        System.out.pritnln("ContactOne added unsuccessfully");
      }

      if(contactService.addContact(contactTwo)) {
        System.out.println("contactTwo added successfully");
        }
      else {
        System.out.println("contactTwo added unsuccessfully");
      }

      //Displaying all contacts
      System.out.println();
      contactService.displayAllContacts();

      //Deleting a contact from the ArrayList
      System.out.println();
      if(contactService.deleteContact("contactOne")) {
        System.out.println("contactOne successfully deleted");
      }
      else {
        System.out.println("contactTwo unsuccessfully deleted");
      }

      //Update contactTwo contact details
      contactService.updateContactFirstName("contactTwo", "Amanda");
      contactService.updateContactLastName("contactTwo", "Whittington");
      contactService.updateContactPhoneNumber("contactTwo", "3015553190");
      contactService.updateAddress("contactTwo", "5505 Frederick Pipe, USA");

      //Display all contacts in ArrayList
      System.out.println();
      contactService.displayAllContacts();

    }
}

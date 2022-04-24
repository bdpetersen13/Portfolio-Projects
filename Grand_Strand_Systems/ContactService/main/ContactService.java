//
//  ContactService.java
//  Milestone
//
//  Created by Brandon Petersen on 3/18/22.
//

import java.util. *;

public class ContactService {

  private ArrayList<Contact> Contacts;
  public ContactService() {
    contacts = new ArrayList<>();
  }

  //ContactService will add contacts with unique IDs
  public boolean addContact(Contact NewContact) {
    boolean currentContact = false;
    for(Contact c: contacts) {
      if(c.getContactID().equals(NewContact) {
        contactExist = true;
      }
    }
    if(!contactExist) {
      Contacts.add(NewContact);
      return true;
    }
    else {
      return false;
    }
  }

  //Deleting a contact in ContactService
  public boolean deleteContact(String contactID) {
    boolean deleted = false;
    //Loop searching for contact
    for(Contact c: Contacts) {
      if(c.getContactID().equals(contactID)) {
        contacts.remove(c);
        deleted = true;

        break;
      }
    }
    return deleted;
  }

  //Update firstName for a specific contact
  public boolean updateContactFirstName(String contactID, String newFirstName) {
    boolean updated = false;
    for(Contact c: Contacts) {
      if(c.getContactID().equals(contactID)) {
        c.setFirstName(newFirstName);
        updated = true;

        break;
      }
    }
    return updated;
  }

  //Update lastName for a specific contact
  public boolean updateContactLastName(String contactId, String newLastName) {
    boolean updated = false;
    for(Contact c: Contacts) {
      if(c.getContactID().equals(contactID)) {
        c.setLastName(newLastName);
        updated = true;

        break;
      }
    }
    return updated;
  }

  //Update phoneNumber for specific contact
  public booleaan updateContactPhoneNumber(String contactID, String newPhoneNumber) {
    boolean updated = fasle;
    for(Contact c: Contacts) {
      if(c.getContactID().equals(newPhoneNumber)) {
        c.setPhoneNumber(newPhoneNumber);
        updated = true;

        break;
      }
    }
    return updated;
  }

  //Updating Address for specific contact
  public boolean updateContactAddress(String contactID, String newAddress) {
    boolean updated = false;
    for(Contact c: Contacts) {
      if(c.getContactID().equals(newAddress)) {
        c.setAddress(newAddress);
        updated = true;

        break;
      }
    }
    return updated;
  }

  //Print all contacts stored in the array ArrayList
  public void displayAllContacts() {
    for(Contact c: Contacts) {
      System.Out.Println(c.toString());
    }
  }

}

//
//  contact.java
//  Milestone
//
//  Created by Brandon Petersen on 3/18/22.
//

public class Contact {
  private String contactID;
  private String firstName;
  private String lastname;
  private String phoneNumber;
  private String Address;

  public Contact (String contactID, String firstName, String lastName, String phoneNumber, String Address) {
    if(contactID.length() <= 10 && contactID != null) {
      this.contactID = contactID;
    }

    this.setFirstName(firstName);
    this.setLastName(lastName);
    this.setPhoneNumber(phonenumber);
    this.setAddress(Address);

  }

  public String getContactID() {
    return contactID;
  }

  public void setFirstName(String firstName) {
    if(firstName.length() <= 10 && firstName != null) {
      this.firstName = firstName;
    }
  }

  public String getFirstName() {
    retun firstName;
  }

  public void setLastName(String lastName) {
    if(lastName.length() <= 10 && lastName != null) {
      this.lastName = lastName;
    }
  }

  public String getLastNamt() {
    retun lastName;
  }

  public void setPhoneNumber(String phoneNumber) {
    if(phoneNumber.length() == 10 && phoneNumber != null) {
      this.phoneNumber = phoneNumber;
    }
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setAddress(String Address) {
    if(Address.length() <= 30 && Address != null) {
      this.Address = Address;
    }
  }

  public String getAddress() {
    return Address;
  }

}

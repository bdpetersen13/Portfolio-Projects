//
//  ContactTest.java
//  Milestone
//
//  Created by Brandon Petersen on 3/18/22.
//

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest {

  protected String contactID, firstName, lastName, phoneNumber, Address;
  protected String contactIDTest, firstNameTest, lastNametest, phoneNumberTest, addresstest;

  @BeforeEach
  void setUp() {
    contactID = "1329F136A7";
    firstName = "Albert";
    lastName = "Smith";
    phoneNumber = "2405556713"
    Address = "67 Murphey RD, USA";
    contactIDTest = "12345678901233457689"
    firstNameTest = "Hamilton Alexander Washingtion";
    lastNametest = "Johnston Burr-Franklin";
    phoneNumberTest = "24055528";
    addresstest = "1486 Kill murfeesboro Road, Suite 1850, NAshville, TN, USA";

  }

  @Test
  void ContactTest() {

    Contact contact = new Contact();
    assertAll("constructor one", ()
                  -> assertNotNull(contact.getContactId()),
              ()
                  -> assertNotNull(contact.getFirstName()),
              ()
                  -> assertNotNull(contact.getLastName()),
              ()
                  -> assertNotNull(contact.getPhoneNumber()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test
  void contactIDAndFirstNameConstructorTest() {
    Contact contact = new Contact(contactID, firstName);
    assertAll("constructor two",
              ()
                  -> assertEquals(contactID, contact.getContactId()),
              ()
                  -> assertEquals(firstName, contact.getFirstName()),
              ()
                  -> assertNotNull(contact.getLastName()),
              ()
                  -> assertNotNull(contact.getPhoneNumber()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test
  void contactIDAndFullNameConstructorTest() {
    Contact contact = new Contact(contactID, firstName, lastName);
    assertAll("constructor three",
              ()
                  -> assertEquals(contactID, contact.getContactId()),
              ()
                  -> assertEquals(firstName, contact.getFirstName()),
              ()
                  -> assertEquals(lastName, contact.getLastName()),
              ()
                  -> assertNotNull(contact.getPhoneNumber()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test
  void contactIDConstructorTest() {
    Contact contact =
        new Contact(contactID, firstName, lastName, phoneNumber);
    assertAll("constructor four",
              ()
                  -> assertEquals(contactID, contact.getContactId()),
              ()
                  -> assertEquals(firstName, contact.getFirstName()),
              ()
                  -> assertEquals(lastName, contact.getLastName()),
              ()
                  -> assertEquals(phoneNumber, contact.getPhoneNumber()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test
  void allTheProperThingsConstructorTest() {
    Contact contact = new Contact(contactID, firstName, lastName, phoneNumber, Address);
    assertAll("constructor all",
              ()
                  -> assertEquals(contactID, contact.getContactId()),
              ()
                  -> assertEquals(firstName, contact.getFirstName()),
              ()
                  -> assertEquals(lastName, contact.getLastName()),
              ()
                  -> assertEquals(phoneNumber, contact.getPhoneNumber()),
              () -> assertEquals(address, contact.getAddress()));
  }

  @Test
  void updateFirstNameTest() {
    Contact contact = new Contact();
    contact.updateFirstName(firstName);
    assertAll(
        "first name",
        ()
            -> assertEquals(firstName, contact.getFirstName()),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateFirstName(null)),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateFirstName(firstNameTest)));
  }

  @Test
  void updateLastNameTest() {
    Contact contact = new Contact();
    contact.updateLastName(lastName);
    assertAll(
        "last name",
        ()
            -> assertEquals(lastName, contact.getLastName()),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateLastName(null)),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateLastName(firstNameTest)));
  }

  @Test
  void updatePhoneNumberTest() {
    Contact contact = new Contact();
    contact.updatePhoneNumber(phoneNumber);
    assertAll("phone number",
              ()
                  -> assertEquals(phoneNumber, contact.getPhoneNumber()),
              ()
                  -> assertThrows(IllegalArgumentException.class,
                                  () -> contact.updatePhoneNumber(null)),
              ()
                  -> assertThrows(
                      IllegalArgumentException.class,
                      () -> contact.updatePhoneNumber(phoneNumberTest)),
              ()
                  -> assertThrows(IllegalArgumentException.class,
                                  () -> contact.updatePhoneNumber(contactID)));
  }

  @Test
  void updateAddressTest() {
    Contact contact = new Contact();
    contact.updateAddress(Address);
    assertAll("phone number",
              ()
                  -> assertEquals(Address, contact.getAddress()),
              ()
                  -> assertThrows(IllegalArgumentException.class,
                                  () -> contact.updateAddress(null)),
              ()
                  -> assertThrows(IllegalArgumentException.class,
                                  () -> contact.updateAddress(addressTest)));

  }
}

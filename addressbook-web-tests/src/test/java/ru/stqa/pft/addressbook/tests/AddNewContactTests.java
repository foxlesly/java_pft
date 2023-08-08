package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;

public class AddNewContactTests extends TestBase {

  @Test
  public void testAddNewContact() {
    app.gotoAddNewContact();
    app.enterInfoAboutNewPerson();
    app.saveNewContact();
    app.logout();
  }

}

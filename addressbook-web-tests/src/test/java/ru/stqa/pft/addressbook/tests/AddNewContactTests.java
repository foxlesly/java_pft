package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;

public class AddNewContactTests extends TestBase {

  @Test
  public void testAddNewContact() {
    app.getNavigationHelper().gotoAddNewContact();
    app.getContactHelper().enterInfoAboutNewPerson();
    app.getContactHelper().saveNewContact();
    //app.getSessionHelper().logout();
  }

}

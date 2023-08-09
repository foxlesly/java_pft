package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;

public class AddNewContactTests extends TestBase {

  @Test
  public void testAddNewContact() {
    app.getNavigationHelper().gotoAddNewContact();
    app.getGroupHelper().enterInfoAboutNewPerson();
    app.getGroupHelper().saveNewContact();
    //app.getSessionHelper().logout();
  }

}

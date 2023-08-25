package ru.stqa.pft.addressbook.tests;

import ru.stqa.pft.addressbook.model.AboutContactInfo;
import org.testng.annotations.*;

public class AddNewContactTests extends TestBase {

  @Test

  public void testAddNewContact() {
    app.getNavigationHelper().gotoAddNewContact();
    AboutContactInfo contactInfo = new AboutContactInfo("231523", "890652365478", "fedotov.dmitriy@mail.ru", "Moscow", "Dmitriy", "Fedotov", "Vasilevich", "test1");
    app.getContactHelper().enterInfoAboutNewPerson(contactInfo, true);
  }
  //app.getSessionHelper().logout();
}



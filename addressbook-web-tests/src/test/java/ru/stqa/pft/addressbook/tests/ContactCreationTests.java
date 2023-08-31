package ru.stqa.pft.addressbook.tests;

import ru.stqa.pft.addressbook.model.AboutContactInfo;
import org.testng.annotations.*;

public class ContactCreationTests extends TestBase {

  @Test

  public void testContactCreation() {
    app.getNavigationHelper().gotoAddNewContact();
    AboutContactInfo newContact = new AboutContactInfo("231523", "890652365478", "fedotov.dmitriy@mail.ru", "Moscow", "Dmitriy", "Fedotov", "Vasilevich", "test1");
    app.getContactHelper().createContact(newContact);
  }
  //app.getSessionHelper().logout();
}



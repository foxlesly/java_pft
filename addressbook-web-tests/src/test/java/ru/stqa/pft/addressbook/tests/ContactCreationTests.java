package ru.stqa.pft.addressbook.tests;

import ru.stqa.pft.addressbook.model.AboutContactInfo;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactCreationTests extends TestBase {

  @Test

  public void testContactCreation() {

    app.getNavigationHelper().gotoAddNewContact();
    AboutContactInfo newContact = new AboutContactInfo("231523", "890652365478", "fedotov.dmitriy@mail.ru", "Moscow", "Dmitriy", "Fedotov", "Vasilevich", "test1");
    if (!app.getGroupHelper().isGroupExists("Test1")){
      app.getNavigationHelper().goToGroupPage();
      app.getGroupHelper().createGroup(new GroupData("Test1", null, null));

    }
    app.getNavigationHelper().gotoAddNewContact();
    app.getContactHelper().createContact(newContact);
  }

  //app.getSessionHelper().logout();
}



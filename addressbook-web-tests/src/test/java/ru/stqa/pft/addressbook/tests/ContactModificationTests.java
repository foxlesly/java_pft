package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AboutContactInfo;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactModificationTests extends TestBase {
  @Test

  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    app.getNavigationHelper().goToGroupPage();
    if (!app.getGroupHelper().isGroupExists("test1")) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
      app.getNavigationHelper().gotoHomePage();
    }
    app.getNavigationHelper().gotoAddNewContact();
    if (!app.getContactHelper().isThereAContact()) {
      AboutContactInfo newContact = new AboutContactInfo("231523", "890652365478", "fedotov.dmitriy@mail.ru", "Moscow", "Dmitriy", "Fedotov", "Vasilevich", "test1");
      app.getContactHelper().createContact(newContact);
    }
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().initContactModification();
    AboutContactInfo modifiedContactInfo = new AboutContactInfo("modifiedHome", "modifiedMobile", "modifiedEmail", "modifiedCity", "modifiedFirstName", "modifiedLastName", "modifiedMiddleName", null);
    app.getContactHelper().enterModifiedContactInfo(modifiedContactInfo, false);
    app.getContactHelper().updateContactInfo();
    app.getNavigationHelper().gotoHomePage();
  }
}

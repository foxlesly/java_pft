package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AboutContactInfo;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @Test

  public void testContactDeletion() {
    app.getNavigationHelper().gotoHomePage();
    app.getNavigationHelper().goToGroupPage();
    if (!app.getGroupHelper().isGroupExists("test1")) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
      app.getNavigationHelper().gotoHomePage();
    }
    app.getNavigationHelper().gotoHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      AboutContactInfo newContact = new AboutContactInfo("231523", "890652365478", "fedotov.dmitriy@mail.ru", "Moscow", "Dmitriy", "Fedotov", "Vasilevich", "test1");
      app.getNavigationHelper().gotoAddNewContact();
      app.getContactHelper().createContact(newContact);
    }

    app.getNavigationHelper().gotoHomePage();
    List<AboutContactInfo> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().confirmDeleteContact();
    app.getNavigationHelper().gotoHomePage();
    List<AboutContactInfo> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
  }
}
package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase {


  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().HomePage();
    app.goTo().groupPage();
    if (!app.group().isGroupExists("test1")) {
      app.group().create(new GroupData().withName("test1"));
      app.goTo().HomePage();
    }
    app.goTo().HomePage();
    if (app.contact().all().size() == 0) {
      ContactData newContact = new ContactData()
              .withHomeNumber("231523")
              .withMobileNumber("890652365478")
              .withMailAddress("fedotov.dmitriy@mail.ru")
              .withCityHome("Moscow")
              .withUserFirstName("Dmitriy")
              .withUserLastName("Fedotov")
              .withUserMiddleName("Vasilevich")
              .withGroup("test1");

      app.goTo().AddNewContact();
      app.contact().create(newContact);
    }

  }

  @Test

  public void testContactDeletion() {

    app.goTo().HomePage();
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.goTo().HomePage();
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size() - 1);
    assertThat(after, equalTo(before.without(deletedContact)));
  }
}
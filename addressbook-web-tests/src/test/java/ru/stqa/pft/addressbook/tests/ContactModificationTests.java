package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().HomePage();
    app.goTo().groupPage();
    if (!app.group().isGroupExists("test1")) {
      app.group().create(new GroupData().withName("test1"));
      app.goTo().HomePage();
    }
    app.goTo().HomePage();
    if (app.contact().list().size() == 0) {
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

  public void testContactModification() {
    app.goTo().HomePage();
    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    app.contact().initContactModification(0);
    ContactData modifyContact = new ContactData()
            .withId(modifiedContact.getId())
            .withHomeNumber("modifiedHome")
            .withMobileNumber("modifiedMobile")
            .withMailAddress("modifiedEmail")
            .withCityHome("modifiedCity")
            .withUserFirstName("modifiedFirstName")
            .withUserLastName("modifiedLastName")
            .withUserMiddleName("modifiedMiddleName");

    app.contact().enterModifiedContact(modifyContact, false);
    app.contact().updateContactInfo();
    app.goTo().HomePage();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());


    before.remove(modifiedContact);
    before.add(modifyContact);
    Assert.assertEquals(before, after);
  }
}

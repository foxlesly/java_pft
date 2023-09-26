package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
    if (app.contact().all().size() == 0) {
      ContactData newContact = new ContactData()
              .withHomePhones("231523")
              .withMobilePhones("890652365478")
              .withMail1("fedotov.dmitriy@mail.ru")
              .withAddress2("Moscow")
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
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId())
            .withHomePhones("modifiedHome")
            .withMobilePhones("modifiedMobile")
            .withMail1("modifiedEmail")
            .withAddress2("modifiedCity")
            .withUserFirstName("modifiedFirstName")
            .withUserLastName("modifiedLastName")
            .withUserMiddleName("modifiedMiddleName");

    app.contact().modify(contact);
    app.goTo().HomePage();
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();

    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }

}

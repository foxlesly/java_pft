package ru.stqa.pft.addressbook.tests;

import ru.stqa.pft.addressbook.model.ContactData;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().HomePage();
    app.goTo().groupPage();
    if (!app.group().isGroupExists("test1")) {
      app.group().create(new GroupData().withName("test1"));
      app.goTo().HomePage();
    }
  }

  @Test

  public void testContactCreation() {
    app.goTo().HomePage();
    Contacts before = app.contact().all();
    app.goTo().AddNewContact();
    ContactData contact = new ContactData()
            .withHomeNumber("231523")
            .withMobileNumber("890652365478")
            .withMailAddress("fedotov.dmitriy@mail.ru")
            .withCityHome("Moscow")
            .withUserFirstName("Dmitriy")
            .withUserLastName("Fedotov")
            .withUserMiddleName("Vasilevich")
            .withGroup("test1");
    app.contact().create(contact);
    app.goTo().HomePage();
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

  }
}



package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;
import java.util.Set;

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
    Set<ContactData> before = app.contact().all();
    app.goTo().AddNewContact();
    ContactData newContact = new ContactData()
            .withHomeNumber("231523")
            .withMobileNumber("890652365478")
            .withMailAddress("fedotov.dmitriy@mail.ru")
            .withCityHome("Moscow")
            .withUserFirstName("Dmitriy")
            .withUserLastName("Fedotov")
            .withUserMiddleName("Vasilevich")
            .withGroup("test1");
    app.contact().create(newContact);
    app.goTo().HomePage();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);


    newContact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(newContact);
    Assert.assertEquals(before, after);

  }
}



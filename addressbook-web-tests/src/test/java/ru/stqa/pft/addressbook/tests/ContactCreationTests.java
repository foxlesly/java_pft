package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

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
    List<ContactData> before = app.contact().list();
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
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(newContact);
    Comparator<? super ContactData> byNameId = (c1, c2) -> {
      String name1 = c1.getUserFirstName() + " " + c1.getUserLastName();
      String name2 = c2.getUserFirstName() + " " + c2.getUserLastName();
      int nameComparison = name1.compareTo(name2);

      if (nameComparison != 0) {
        return nameComparison;
      } else {
        // Если имена одинаковые, сравниваем по id.
        return Integer.compare(c1.getId(), c2.getId());
      }
    };

    before.sort(byNameId);
    after.sort(byNameId);
    Assert.assertEquals(before, after);

  }
}



package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

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
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().initContactModification(index);
    ContactData modifiedContact = new ContactData()
            .withId(before.get(index).getId())
            .withHomeNumber("modifiedHome")
            .withMobileNumber("modifiedMobile")
            .withMailAddress("modifiedEmail")
            .withCityHome("modifiedCity")
            .withUserFirstName("modifiedFirstName")
            .withUserLastName("modifiedLastName")
            .withUserMiddleName("modifiedMiddleName");

    app.contact().enterModifiedContact(modifiedContact, false);
    app.contact().updateContactInfo();
    app.goTo().HomePage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());


    before.remove(index);
    before.add(modifiedContact);
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
    // Сортируем списки
    before.sort(byNameId);
    after.sort(byNameId);
    Assert.assertEquals(before, after);
  }
}

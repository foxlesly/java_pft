package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test

  public void testContactCreation() {
    app.goTo().groupPage();
    if (!app.group().isGroupExists("test1")) {
      app.group().create(new GroupData("test1", null, null));
    }
    app.goTo().gotoHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.goTo().gotoAddNewContact();
    ContactData newContact = new ContactData("231523", "890652365478", "fedotov.dmitriy@mail.ru", "Moscow", "Dmitriy", "Fedotov", "Vasilevich", "test1");
    app.getContactHelper().createContact(newContact);
    app.goTo().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
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



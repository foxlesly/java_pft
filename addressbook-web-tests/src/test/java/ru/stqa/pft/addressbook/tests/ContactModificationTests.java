package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {
  @Test

  public void testContactModification() {
    app.goTo().gotoHomePage();
    app.goTo().groupPage();
    if (!app.group().isGroupExists("test1")) {
      app.group().create(new GroupData("test1", null, null));
      app.goTo().gotoHomePage();
    }
    app.goTo().gotoHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      ContactData newContact = new ContactData(
              "231523",
              "890652365478",
              "fedotov.dmitriy@mail.ru",
              "Moscow", "Dmitriy",
              "Fedotov",
              "Vasilevich",
              "test1");

      app.goTo().gotoAddNewContact();
      app.getContactHelper().createContact(newContact);
    }
    app.goTo().gotoHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
   // app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().initContactModification(before.size() - 1);
    ContactData modifiedContactInfo = new ContactData
            (before.get(before.size() - 1).getId(),
                    "modifiedHome",
                    "modifiedMobile",
                    "modifiedEmail",
                    "modifiedCity",
                    "modifiedFirstName",
                    "modifiedLastName",
                    "modifiedMiddleName",
                    null);

    app.getContactHelper().enterModifiedContactInfo(modifiedContactInfo, false);
    app.getContactHelper().updateContactInfo();
    app.goTo().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());


    before.remove(before.size() - 1);
    before.add(modifiedContactInfo);
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

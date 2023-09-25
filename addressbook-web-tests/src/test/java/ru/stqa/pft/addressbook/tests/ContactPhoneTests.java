package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().HomePage();
    if (app.contact().all().size() == 0) {
      ContactData newContact = new ContactData()
              .withHomePhones("231523")
              .withMobilePhones("890652365478")
              .withWorkPhones("565656")
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
  public void testsContactPhones() {
    app.goTo().HomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFormEditForm =  app.contact().infoFormEditForm(contact);

    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFormEditForm)));

  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}

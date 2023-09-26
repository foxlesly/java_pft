package ru.stqa.pft.addressbook.tests;

import ru.stqa.pft.addressbook.model.ContactData;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;


import java.io.File;

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
    File photo = new File("src/test/resources/fruits.PNG");
    Contacts before = app.contact().all();
    app.goTo().AddNewContact();
    ContactData contact = new ContactData()
            .withHomePhones("231523")
            .withMobilePhones("890652365478")
            .withWorkPhones("5656565")
            .withMail1("fedotov.dmitriy@mail.ru")
            .withAddress2("Moscow")
            .withUserFirstName("Dmitriy")
            .withUserLastName("Fedotov")
            .withUserMiddleName("Vasilevich")
            .withPhoto(photo)
            .withGroup("test1");

    app.contact().create(contact);
    app.goTo().HomePage();
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

  }

//  @Test
//
//  public void testCurrentDir(){
//    File currentDir = new File(".");
//    System.out.println(currentDir.getAbsolutePath());
//    File photo = new File("src/test/resources/fruits.PNG");
//    System.out.println(photo.getAbsolutePath());
//    System.out.println(photo.exists());
//  }
}



package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AboutContactInfo;

public class ContactModificationTests extends TestBase{
  @Test

  public void testContactModification(){
    app.getNavigationHelper().gotoHomePage();
  //  app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().enterInfoAboutNewPerson();
    app.getContactHelper().updateContactInfo();
    app.getNavigationHelper().gotoHomePage();
}
}

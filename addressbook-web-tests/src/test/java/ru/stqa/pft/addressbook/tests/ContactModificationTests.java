package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AboutContactInfo;

public class ContactModificationTests extends TestBase {
  @Test

  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().initContactModification();
    AboutContactInfo modifiedContactInfo = new AboutContactInfo("modifiedHome", "modifiedMobile", "modifiedEmail", "modifiedCity", "modifiedFirstName", "modifiedLastName", "modifiedMiddleName");
    app.getContactHelper().enterModifiedContactInfo(modifiedContactInfo);
    app.getContactHelper().updateContactInfo();
    app.getNavigationHelper().gotoHomePage();
  }
}

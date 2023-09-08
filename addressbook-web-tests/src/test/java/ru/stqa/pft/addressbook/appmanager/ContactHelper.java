package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.AboutContactInfo;
import ru.stqa.pft.addressbook.model.GroupData;




public class ContactHelper extends HelperBase {
  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void enterInfoAboutNewPerson(AboutContactInfo contactInfo, boolean creation) {
    addContactInfo(contactInfo, creation);
  }

  public void enterModifiedContactInfo(AboutContactInfo contactInfo, boolean creation) {
    addContactInfo(contactInfo, creation);
  }

  private void addContactInfo(AboutContactInfo contactInfo, boolean creation) {
    type(By.name(contactInfo.getUserFirstName()), By.name("firstname"), contactInfo.getUserFirstName());
    type(By.name(contactInfo.getUserMiddleName()), By.name("middlename"), contactInfo.getUserMiddleName());
    type(By.name(contactInfo.getUserLastName()), By.name("lastname"), contactInfo.getUserLastName());
    type(By.name(contactInfo.getHomeNumber()), By.name("home"), contactInfo.getHomeNumber());
    type(By.name(contactInfo.getMobileNumber()), By.name("mobile"), contactInfo.getMobileNumber());
    type(By.name(contactInfo.getMailAddress()), By.name("email"), contactInfo.getMailAddress());
    type(By.name(contactInfo.getCityHome()), By.name("address2"), contactInfo.getCityHome());

    if (creation) { // Проверка, создание это или модификация
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactInfo.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));

    }
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void deleteSelectedContact() {
    wd.findElement(By.xpath("//input[@value='Delete']")).click();
  }

  public void confirmDeleteContact() {
    wd.switchTo().alert().accept();
  }

  public void saveNewContact() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void initContactModification() {
    click(By.xpath("//td[8]/a/img"));
  }

  public void updateContactInfo() {
    click(By.xpath("//div[@id='content']/form/input[22]"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void createContact(AboutContactInfo contact) {
    enterInfoAboutNewPerson(contact, true);
    saveNewContact();
  }

  public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();
  }
}

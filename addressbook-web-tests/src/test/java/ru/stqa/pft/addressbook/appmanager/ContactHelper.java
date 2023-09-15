package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;


public class ContactHelper extends HelperBase {
  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void enterInfoAboutNewPerson(ContactData contactInfo, boolean creation) {
    addContactInfo(contactInfo, creation);
  }

  public void enterModifiedContactInfo(ContactData contactInfo, boolean creation) {
    addContactInfo(contactInfo, creation);
  }

  private void addContactInfo(ContactData contactInfo, boolean creation) {
    type(By.name("firstname"), contactInfo.getUserFirstName());
    type(By.name("middlename"), contactInfo.getUserMiddleName());
    type(By.name("lastname"), contactInfo.getUserLastName());
    type(By.name("home"), contactInfo.getHomeNumber());
    type(By.name("mobile"), contactInfo.getMobileNumber());
    type(By.name("email"), contactInfo.getMailAddress());
    type(By.name("address2"), contactInfo.getCityHome());

    if (creation) { // Проверка, создание это или модификация
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactInfo.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

//  public void selectContact() {
//    click(By.name("selected[]"));
//  }

  public void deleteSelectedContact() {
    wd.findElement(By.xpath("//input[@value='Delete']")).click();
  }

  public void confirmDeleteContact() {
    wd.switchTo().alert().accept();
  }

  public void saveNewContact() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

//  public void initContactModification() {
//    click(By.xpath("//td[8]/a/img"));
//  }
  public void initContactModification(int index) {
    wd.findElements(By.cssSelector("img[alt='Edit']")).get(index).click();
  }

  public void updateContactInfo() {
    click(By.xpath("//div[@id='content']/form/input[22]"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void createContact(ContactData contact) {
    enterInfoAboutNewPerson(contact, true);
    saveNewContact();
  }

  public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> contactDataElements = element.findElements(By.cssSelector("td"));
      int id = Integer.parseInt(contactDataElements.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String userFirstName = contactDataElements.get(2).getText();
      String userLastName = contactDataElements.get(1).getText();
      ContactData contact = new ContactData(
              id,
              null,
              null,
              null,
              null,
              userFirstName,
              userLastName,
              null,
              null);
      contacts.add(contact);
    }
    return contacts;
  }

}

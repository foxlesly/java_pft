package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;


public class ContactHelper extends HelperBase {
  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void enterInfoAboutNewPerson(ContactData contactInfo, boolean creation) {
    addContactInfo(contactInfo, creation);
  }

  public void enterModifiedContact(ContactData contactInfo, boolean creation) {
    addContactInfo(contactInfo, creation);
  }

  private void addContactInfo(ContactData contactInfo, boolean creation) {
    type(By.name("firstname"), contactInfo.getUserFirstName());
    type(By.name("middlename"), contactInfo.getUserMiddleName());
    type(By.name("lastname"), contactInfo.getUserLastName());
    type(By.name("home"), contactInfo.getHomePhone());
    type(By.name("mobile"), contactInfo.getMobilePhone());
    type(By.name("work"), contactInfo.getWorkPhone());
    type(By.name("email"), contactInfo.getEmail1());
    type(By.name("email2"), contactInfo.getEmail2());
    type(By.name("email3"), contactInfo.getEmail3());
    // type(By.name("address2"), contactInfo.getAddress2());
    type(By.name("address"), contactInfo.getAddress());
    attach(By.name("photo"), contactInfo.getPhoto());

    if (creation) { // Проверка, создание это или модификация
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactInfo.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value = '" + id + "']")).click();
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

  public void initContactModificationById(int id) {
    wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
  }

  public void updateContactInfo() {
    click(By.xpath("//div[@id='content']/form/input[22]"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void create(ContactData contact) {
    enterInfoAboutNewPerson(contact, true);
    saveNewContact();
    contactCache = null;
  }

  public void modify(ContactData contact) {
    initContactModificationById(contact.getId());
    enterModifiedContact(contact, false);
    updateContactInfo();
    contactCache = null;
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContact();
    confirmDeleteContact();
    contactCache = null;
  }


  public int count() {
    return wd.findElements(
            By.name("selected[]")).size();
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> contactDataElements = element.findElements(By.cssSelector("td"));
      int id = Integer.parseInt(contactDataElements.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String userFirstName = contactDataElements.get(2).getText();
      String userLastName = contactDataElements.get(1).getText();
      String allEmails = contactDataElements.get(4).getText();
      String allPhones = contactDataElements.get(5).getText();
      String address = contactDataElements.get(3).getText();
      ContactData contact = new ContactData().withId(id).withUserFirstName(userFirstName)
              .withUserLastName(userLastName).withAllPhones(allPhones).withAllEmails(allEmails).withAddress(address);
      contactCache.add(contact);
    }
    return new Contacts(contactCache);
  }

  public ContactData infoFormEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String middlename = wd.findElement(By.name("middlename")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    wd.navigate().back();
    return new ContactData()
            .withId(contact.getId()).withUserFirstName(firstname)
            .withUserLastName(lastname).withUserMiddleName(middlename)
            .withHomePhones(home)
            .withMobilePhones(mobile)
            .withWorkPhones(work)
            .withMail1(email)
            .withEmail2(email2)
            .withEmail3(email3)
            .withAddress(address);

  }
}

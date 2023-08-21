package ru.stqa.pft.addressbook.appmanager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.AboutContactInfo;


public class ContactHelper extends HelperBase {
  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void enterInfoAboutNewPerson(AboutContactInfo contactInfo) {
    addContactInfo(contactInfo);
  }

  public void enterModifiedContactInfo(AboutContactInfo contactInfo) {
    addContactInfo(contactInfo);
  }

  private void addContactInfo(AboutContactInfo contactInfo) {
    type(By.name(contactInfo.getUserFirstName()), By.name("firstname"), contactInfo.getUserFirstName());
    type(By.name(contactInfo.getUserMiddleName()), By.name("middlename"), contactInfo.getUserMiddleName());
    type(By.name(contactInfo.getUserLastName()), By.name("lastname"), contactInfo.getUserLastName());
    type(By.name(contactInfo.getHomeNumber()), By.name("home"), contactInfo.getHomeNumber());
    type(By.name(contactInfo.getMobileNumber()), By.name("mobile"), contactInfo.getMobileNumber());
    type(By.name(contactInfo.getMailAddress()), By.name("email"), contactInfo.getMailAddress());
    type(By.name(contactInfo.getCityHome()), By.name("address2"), contactInfo.getCityHome());
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
}

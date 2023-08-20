package ru.stqa.pft.addressbook.appmanager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.AboutContactInfo;


public class ContactHelper extends HelperBase {
  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void enterInfoAboutNewPerson() {
    addContatInfo(new AboutContactInfo("home", "mobile", "email", "address2", "firstname", "lastname", "middlename"));
  }
    private void addContatInfo (AboutContactInfo contactInfoGroup) {
    type(By.name(contactInfoGroup.getUserFirstName()), By.name("firstname"), "Dmitriy");
    type(By.name(contactInfoGroup.getUserMiddleName()), By.name("middlename"), "Vasilevich");
    type(By.name(contactInfoGroup.getUserLastName()), By.name("lastname"), "Fedotov");
    type(By.name(contactInfoGroup.getHomeNumber()), By.name("home"), "231523");
    type(By.name(contactInfoGroup.getMobileNumber()), By.name("mobile"), "890652365478");
    type(By.name(contactInfoGroup.getMailAddress()), By.name("email"), "fedotov.dmitriy@mail.ru");
    type(By.name(contactInfoGroup.getCityHome()), By.name("address2"), "Moscow");
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

package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.AboutContactInfo;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void enterInfoAboutNewPerson() {
    addContatInfo(new AboutContactInfo("home", "mobile", "email", "address2", "firstname", "lastname", "middlename"));
  }

  private void addContatInfo(AboutContactInfo contactInfoGroup) {
    type(By.name(contactInfoGroup.getUserFirstName()), By.name("firstname"), "Dmitriy");
    type(By.name(contactInfoGroup.getUserMiddleName()), By.name("middlename"), "Vasilevich");
    type(By.name(contactInfoGroup.getUserLastName()), By.name("lastname"), "Fedotov");
    type(By.name(contactInfoGroup.getHomeNumber()), By.name("home"), "231523");
    type(By.name(contactInfoGroup.getMobileNumber()), By.name("mobile"), "890652365478");
    type(By.name(contactInfoGroup.getMailAddress()), By.name("email"), "fedotov.dmitriy@mail.ru");
    type(By.name(contactInfoGroup.getCityHome()), By.name("address2"), "Moscow");
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  public void selectGroup() {
    click(By.name("selected[]"));
  }

  public void saveNewContact() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }
}

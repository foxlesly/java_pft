package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.AboutContactInfo;

public class NavigationHelper extends HelperBase {
  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void goToGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }

  public void gotoAddNewContact() {
    click(By.linkText("add new"));
  }

  public void gotoHomePage() {
    wd.findElement(By.linkText("home")).click();
  }

}

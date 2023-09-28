package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.*;

import java.io.File;

public class HelperBase {
  protected WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  protected void type(By contactInfoGroup, By locator, String text) {
    click(locator);
    if (text != null) {
      String existingText = wd.findElement(locator).getAttribute("value");
      if (!text.equals(existingText)) {
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
      }
    }

  }

  protected void attach (By locator, File file) {
    if (file != null) {
        wd.findElement(locator).sendKeys(file.getAbsolutePath());
      }

  }

  protected void click(By locator) {
    wd.findElement(locator).click();
  }

  protected void type(By locator, String text) {
    type(locator, locator, text);
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }

//  public String getAttribute(By locator, String attributeName) {
//    WebElement element = wd.findElement(locator);
//    return element.getAttribute(attributeName);
//  }
}

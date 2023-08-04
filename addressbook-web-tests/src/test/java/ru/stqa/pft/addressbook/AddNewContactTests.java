package ru.stqa.pft.addressbook;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AddNewContactTests {
  private WebDriver driver;


  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get("http://localhost/addressbook/edit.php");
    login("admin", "secret");
  }

  private void login(String username, String password) {
    driver.findElement(By.name("user")).click();
    driver.findElement(By.name("user")).clear();
    driver.findElement(By.name("user")).sendKeys(username);
    driver.findElement(By.name("pass")).click();
    driver.findElement(By.name("pass")).clear();
    driver.findElement(By.name("pass")).sendKeys(password);
    driver.findElement(By.xpath("//input[@value='Login']")).click();
  }

  @Test
  public void testAddNewContact() throws Exception {
    gotoAddNewContact();
    enterInfoAboutNewPerson();
    saveNewContact();
    logout();
  }

  private void logout() {
    driver.findElement(By.linkText("Logout")).click();
  }

  private void enterInfoAboutNewPerson() {
    addFullName(new FullUserNameInfo("firstname", "lastname", "middlename"));
    addContatInfo(new ContactInfo("home", "mobile", "email", "address2"));
  }

  private void addContatInfo(ContactInfo contactInfoGroup) {
    driver.findElement(By.name("home")).click();
    driver.findElement(By.name("home")).clear();
    driver.findElement(By.name(contactInfoGroup.getHomeNumber())).sendKeys("231523");
    driver.findElement(By.name("mobile")).click();
    driver.findElement(By.name("mobile")).clear();
    driver.findElement(By.name(contactInfoGroup.getMobileNumber())).sendKeys("890652365478");
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name(contactInfoGroup.getMailAddress())).sendKeys("fedotov.dmitriy@mail.ru");
    driver.findElement(By.name("address2")).click();
    driver.findElement(By.name("address2")).clear();
    driver.findElement(By.name(contactInfoGroup.getCityHome())).sendKeys("Moscow");
  }

  private void addFullName(FullUserNameInfo fullUserNameGroup) {
    driver.findElement(By.name("firstname")).click();
    driver.findElement(By.name("firstname")).clear();
    driver.findElement(By.name(fullUserNameGroup.getUserFirstName())).sendKeys("Dmitriy");
    driver.findElement(By.name("lastname")).click();
    driver.findElement(By.name("lastname")).clear();
    driver.findElement(By.name(fullUserNameGroup.getUserLastName())).sendKeys("Fedotov");
    driver.findElement(By.name("middlename")).click();
    driver.findElement(By.name("middlename")).clear();
    driver.findElement(By.name(fullUserNameGroup.getUserMiddleName())).sendKeys("Vasilevich");
  }

  private void saveNewContact() {
    driver.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  private void gotoAddNewContact() {
    driver.findElement(By.linkText("add new")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

}

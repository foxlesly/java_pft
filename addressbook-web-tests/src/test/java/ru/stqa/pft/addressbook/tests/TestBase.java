package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.appmanager.ApplicationManadger;

public class TestBase {

  protected final ApplicationManadger app = new ApplicationManadger(BrowserType.CHROME);

  @BeforeMethod(alwaysRun = true)
  public void setUp() {
    app.init();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown()  {
    app.stop();
  }

}

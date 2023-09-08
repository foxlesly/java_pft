package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().goToGroupPage();
    int before = app.getContactHelper().getGroupCount();
    app.getGroupHelper().createGroup(new GroupData("Test1", null, null));
    int after = app.getContactHelper().getGroupCount();
    Assert.assertEquals(after, before + 1);

  }

}

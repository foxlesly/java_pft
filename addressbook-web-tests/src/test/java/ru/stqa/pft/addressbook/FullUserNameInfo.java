package ru.stqa.pft.addressbook;

public class FullUserNameInfo {
  private final String userFirstName;
  private final String userLastName;
  private final String userMiddleName;

  public FullUserNameInfo(String userFirstName, String userLastName, String userMiddleName) {
    this.userFirstName = userFirstName;
    this.userLastName = userLastName;
    this.userMiddleName = userMiddleName;
  }

  public String getUserFirstName() {
    return userFirstName;
  }

  public String getUserLastName() {
    return userLastName;
  }

  public String getUserMiddleName() {
    return userMiddleName;
  }
}

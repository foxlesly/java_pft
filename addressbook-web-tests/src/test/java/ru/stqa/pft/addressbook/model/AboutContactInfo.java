package ru.stqa.pft.addressbook.model;

public class AboutContactInfo {
  private final String homeNumber;
  private final String mobileNumber;
  private final String mailAddress;
  private final String cityHome;
  private final String userFirstName;
  private final String userLastName;
  private final String userMiddleName;
  private final String group;

  public AboutContactInfo(String homeNumber, String MobileNumber, String mailAddress, String cityHome, String userFirstName, String userLastName, String userMiddleName,String group) {
    this.homeNumber = homeNumber;
    this.mobileNumber = MobileNumber;
    this.mailAddress = mailAddress;
    this.cityHome = cityHome;
    this.userFirstName = userFirstName;
    this.userLastName = userLastName;
    this.userMiddleName = userMiddleName;
    this.group = group;
  }

  public String getHomeNumber() {
    return homeNumber;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public String getMailAddress() {
    return mailAddress;
  }

  public String getCityHome() {
    return cityHome;
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

  public String getGroup() {
    return group;
  }
}

package ru.stqa.pft.addressbook;

public class ContactInfo {
  private final String homeNumber;
  private final String mobileNumber;
  private final String mailAddress;
  private final String cityHome;

  public ContactInfo(String homeNumber, String MobileNumber, String mailAddress, String cityHome) {
    this.homeNumber = homeNumber;
    this.mobileNumber = MobileNumber;
    this.mailAddress = mailAddress;
    this.cityHome = cityHome;
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
}

package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class AboutContactInfo {

  private int id;

  public int getId() {
    return id;
  }

  private final String homeNumber;
  private final String mobileNumber;
  private final String mailAddress;
  private final String cityHome;
  private final String userFirstName;
  private final String userLastName;
  private final String userMiddleName;
  private final String group;


  public AboutContactInfo(int id, String homeNumber, String MobileNumber,
                          String mailAddress, String cityHome, String userFirstName, String userLastName, String userMiddleName, String group) {
    this.id = id;
    this.homeNumber = homeNumber;
    this.mobileNumber = MobileNumber;
    this.mailAddress = mailAddress;
    this.cityHome = cityHome;
    this.userFirstName = userFirstName;
    this.userLastName = userLastName;
    this.userMiddleName = userMiddleName;
    this.group = group;
  }


  public AboutContactInfo(String homeNumber, String mobileNumber, String mailAddress, String cityHome, String userFirstName, String userLastName, String userMiddleName, String group) {
    this.id = Integer.MAX_VALUE;
    this.homeNumber = homeNumber;
    this.mobileNumber = mobileNumber;
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

  @Override
  public String toString() {
    return "AboutContactInfo{" +
            "id=" + id +
            ", homeNumber='" + homeNumber + '\'' +
            ", mobileNumber='" + mobileNumber + '\'' +
            ", mailAddress='" + mailAddress + '\'' +
            ", cityHome='" + cityHome + '\'' +
            ", userFirstName='" + userFirstName + '\'' +
            ", userLastName='" + userLastName + '\'' +
            ", userMiddleName='" + userMiddleName + '\'' +
            ", group='" + group + '\'' +
            '}';
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    AboutContactInfo that = (AboutContactInfo) o;

    if (id != that.id) return false;
    if (!Objects.equals(homeNumber, that.homeNumber)) return false;
    if (!Objects.equals(mobileNumber, that.mobileNumber)) return false;
    if (!Objects.equals(mailAddress, that.mailAddress)) return false;
    if (!Objects.equals(cityHome, that.cityHome)) return false;
    if (!Objects.equals(userFirstName, that.userFirstName)) return false;
    if (!Objects.equals(userLastName, that.userLastName)) return false;
    if (!Objects.equals(userMiddleName, that.userMiddleName))
      return false;
    return Objects.equals(group, that.group);
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (homeNumber != null ? homeNumber.hashCode() : 0);
    result = 31 * result + (mobileNumber != null ? mobileNumber.hashCode() : 0);
    result = 31 * result + (mailAddress != null ? mailAddress.hashCode() : 0);
    result = 31 * result + (cityHome != null ? cityHome.hashCode() : 0);
    result = 31 * result + (userFirstName != null ? userFirstName.hashCode() : 0);
    result = 31 * result + (userLastName != null ? userLastName.hashCode() : 0);
    result = 31 * result + (userMiddleName != null ? userMiddleName.hashCode() : 0);
    result = 31 * result + (group != null ? group.hashCode() : 0);
    return result;
  }
}

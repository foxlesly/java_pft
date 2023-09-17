package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {

  private int id = Integer.MAX_VALUE;;

  public int getId() {
    return id;
  }

  private String homeNumber;
  private String mobileNumber;
  private String mailAddress;
  private String cityHome;
  private String userFirstName;
  private String userLastName;
  private String userMiddleName;
  private String group;

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
            ", userFirstName='" + userFirstName + '\'' +
            ", userLastName='" + userLastName + '\'' +
            '}';
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withHomeNumber(String homeNumber) {
    this.homeNumber = homeNumber;
    return this;
  }

  public ContactData withMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
    return this;
  }

  public ContactData withMailAddress(String mailAddress) {
    this.mailAddress = mailAddress;
    return this;
  }

  public ContactData withCityHome(String cityHome) {
    this.cityHome = cityHome;
    return this;
  }

  public ContactData withUserFirstName(String userFirstName) {
    this.userFirstName = userFirstName;
    return this;
  }

  public ContactData withUserLastName(String userLastName) {
    this.userLastName = userLastName;
    return this;
  }

  public ContactData withUserMiddleName(String userMiddleName) {
    this.userMiddleName = userMiddleName;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (!Objects.equals(userFirstName, that.userFirstName)) return false;
    return Objects.equals(userLastName, that.userLastName);
  }

  @Override
  public int hashCode() {
    int result = userFirstName != null ? userFirstName.hashCode() : 0;
    result = 31 * result + (userLastName != null ? userLastName.hashCode() : 0);
    return result;
  }
}

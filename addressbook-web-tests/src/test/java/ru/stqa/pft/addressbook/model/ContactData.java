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
  private String workPhone;

  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  private String allPhones;

  public String getHomePhone() {
    return homeNumber;
  }

  public String getMobilePhone() {
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

  public String getWorkPhone() {
    return workPhone;
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

  public ContactData withHomePhones(String homeNumber) {
    this.homeNumber = homeNumber;
    return this;
  }

  public ContactData withWorkPhones(String work) {
    this.workPhone = work;
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

  public ContactData withMobilePhones(String mobileNumber) {
    this.mobileNumber = mobileNumber;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (!Objects.equals(userFirstName, that.userFirstName)) return false;
    return Objects.equals(userLastName, that.userLastName);
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (userFirstName != null ? userFirstName.hashCode() : 0);
    result = 31 * result + (userLastName != null ? userLastName.hashCode() : 0);
    return result;
  }
}

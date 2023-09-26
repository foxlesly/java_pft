package ru.stqa.pft.addressbook.model;

import java.io.File;
import java.util.Objects;

public class ContactData {

  private int id = Integer.MAX_VALUE;
  ;

  public int getId() {
    return id;
  }

  private String homeNumber;
  private String mobileNumber;
  private String cityHome;
  private String userFirstName;
  private String userLastName;
  private String userMiddleName;
  private String group;
  private String workPhone;
  private String allPhones;

  private String allEmails;
  private String mail;
  private String email2;
  private String email3;
  private String address;

  private File photo;

  // private String allAddress;

  public String getAllPhones() {
    return allPhones;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getHomePhone() {
    return homeNumber;
  }

  public String getMobilePhone() {
    return mobileNumber;
  }

  // public String getAddress2() {
//    return cityHome;
//  }
  public String getGroup() {
    return group;
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

  public String getEmail1() {
    return mail;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public String getAddress() {
    return address;
  }

//  public String getAllddress() {
//    return allAddress;
//  }

  public File getPhoto() {
    return photo;
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

  public ContactData withMobilePhones(String mobileNumber) {
    this.mobileNumber = mobileNumber;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withMail1(String mailAddress) {
    this.mail = mailAddress;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
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

  public ContactData withAddress2(String cityHome) {
    this.cityHome = cityHome;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }
//  public ContactData withAllAddress(String allAddress) {
//    this.allAddress = allAddress;
//    return this;
//  }


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

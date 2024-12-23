package com.example.airport.viewModel.admin.user;

public class UserViewModel {
  private int id;
  private String surname;
  private String name;
  private String lastName;
  private String birthDate;
  private String login;
  private String password;
  private String userRole;

  public UserViewModel(int id, String surname, String name, String lastName, String birthDay, String login, String password, String userRole) {
    this.id = id;
    this.surname = surname;
    this.name = name;
    this.lastName = lastName;
    setBirthDate(birthDay);
    this.login = login;
    this.password = password;
    this.userRole = userRole;
  }

  protected UserViewModel() {}

  public int getId() {
    return id;
  }

  public String getSurname() {
    return surname;
  }

  public String getName() {
    return name;
  }


  public String getLastName() {
    return lastName;
  }

  public String getLogin() {
    return login;
  }

  public String getBirthDate() {
    return birthDate;
  }

  public String getPassword() {
    return password;
  }

  public String getUserRole() {
    return userRole;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public void setBirthDate(String birthDay) {
    this.birthDate = birthDay.substring(0, 10);
  }

  public void setUserRole(String userRole) {
    this.userRole = userRole;
  }
}

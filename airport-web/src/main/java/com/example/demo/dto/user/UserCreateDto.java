package com.example.demo.dto.user;

import java.time.LocalDateTime;

public class UserCreateDto {
  private String surname;
  private String name;
  private String lastName;
  private LocalDateTime birthDate;
  private String login;
  private String password;

  public UserCreateDto(String surname, String name, String lastName, LocalDateTime birthDate, String login, String password) {
    this.surname = surname;
    this.name = name;
    this.lastName = lastName;
    this.birthDate = birthDate;
    this.login = login;
    this.password = password;
  }

  protected  UserCreateDto() { }

  public String getSurname() {
    return surname;
  }

  public String getName() {
    return name;
  }

  public String getLastName() {
    return lastName;
  }

  public LocalDateTime getBirthDate() {
    return birthDate;
  }

  public String getLogin() {
    return login;
  }

  public String getPassword() {
    return password;
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

  public void setBirthDate(LocalDateTime birthDate) {
    this.birthDate = birthDate;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}

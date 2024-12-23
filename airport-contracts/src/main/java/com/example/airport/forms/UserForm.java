package com.example.airport.forms;

import jakarta.validation.constraints.NotBlank;

public class UserForm {
  private int id;
  private String name;
  private String surname;
  private String lastName;
  private String birthDate;
  private String login;
  private String password;

  public UserForm(String name, String surname, String secondName, String birthDate, String login, String password) {
    setSurname(surname);
    setName(name);
    setLastName(secondName);
    setBirthDate(birthDate);
    setLogin(login);
    setPassword(password);
  }

  protected UserForm() {}

  public int getId() {
    return id;
  }

  @NotBlank(message = "Имя обязательно")
  public String getSurname() {
    return surname;
  }

  @NotBlank(message = "Фамилия обязательна")
  public String getName() {
    return name;
  }

  public String getLastName() {
    return lastName;
  }

  @NotBlank(message = "Дата рождения обязательна")
  public String getBirthDate() {
    return birthDate;
  }

  @NotBlank(message = "Логин обязателен")
  public String getLogin() {
    return login;
  }

  @NotBlank(message = "Пароль обязателен")
  public String getPassword() {
    return password;
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

  public void setLastName(String secondName) {
    this.lastName = secondName;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}

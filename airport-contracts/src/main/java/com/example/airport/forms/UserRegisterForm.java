package com.example.airport.forms;

import jakarta.validation.constraints.NotBlank;

public class UserRegisterForm {
  private String surname;
  private String name;
  private String lastName;
  private String birthDate;
  private String login;
  private String password;
  private String confirmPassword;

  public UserRegisterForm(String surname, String name, String lastName, String birthDate, String login, String password, String confirmPassword) {
    this.surname = surname;
    this.name = name;
    this.lastName = lastName;
    this.birthDate = birthDate;
    this.login = login;
    this.password = password;
    this.confirmPassword = confirmPassword;
  }

  protected  UserRegisterForm() { }

  @NotBlank(message="Фамилия обязательна")
  public String getSurname() {
    return surname;
  }

  @NotBlank(message="Имя обязательно")
  public String getName() {
    return name;
  }

  public String getLastName() {
    return lastName;
  }


  @NotBlank(message="Дата рождения обязательна")
  public String getBirthDate() {
    return birthDate;
  }

  @NotBlank(message="Логин обязателен")
  public String getLogin() {
    return login;
  }


  @NotBlank(message="Пароль обязателен")
  public String getPassword() {
    return password;
  }

  @NotBlank(message="Необходимо повторить пароль")
  public String getConfirmPassword() {
    return confirmPassword;
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

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
  }
}

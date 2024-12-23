package com.example.demo.dto.user;

import java.time.LocalDateTime;
import java.util.Set;

import com.example.demo.domain.Benefit;
import com.fasterxml.jackson.annotation.JsonFormat;

public class UserDto {
  private int id;
  private String surname;
  private String name;
  private String lastName;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime birthDate;
  private String login;
  private String password;
  private Set<Benefit> benefits;
  private String userRole;

  public UserDto(int id, String surname, String name, String lastName, LocalDateTime birthDate, String login, String password, String userRole) {
    this.id = id;
    this.surname = surname;
    this.name = name;
    this.lastName = lastName;
    this.birthDate = birthDate;
    this.login = login;
    this.password = password;
    this.userRole = userRole;
  }

  protected UserDto() {}

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

  public LocalDateTime getBirthDate() {
    return birthDate;
  }

  public String getLogin() {
    return login;
  }

  public String getPassword() {
    return password;
  }

  public Set<Benefit> getBenefits() {
    return benefits;
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

  public void setBirthDate(LocalDateTime birthDate) {
    this.birthDate = birthDate;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setBenefits(Set<Benefit> benefits) {
    this.benefits = benefits;
  }

  public void setUserRole(String userRole) {
    this.userRole = userRole;
  }
}

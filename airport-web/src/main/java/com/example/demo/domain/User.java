package com.example.demo.domain;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;

import com.example.demo.domain.enums.UserRole;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
  private String surname;
  private String name;
  private String lastName;
  private LocalDateTime birthDate;
  private String login;
  private String password;
  private Set<Benefit> benefits;
  private UserRole userRole;

  public User(String surname, String name, String lastName, LocalDateTime birthDate, String login, String password) {
    setSurname(surname);
    setName(name);
    setLastName(lastName);
    setBirthDate(birthDate);
    setLogin(login);
    setPassword(password);
    this.benefits = new TreeSet<>();
  }

  protected User() {
    this.benefits = new TreeSet<>();
  }

  @Column(name = "surname", nullable = false)
  public String getSurname() {
    return surname;
  }

  @Column(name = "name", nullable = false)
  public String getName() {
    return name;
  }

  @Column(name = "last_name")
  public String getLastName() {
    return lastName;
  }

  @Column(name = "birth_date", nullable = false)
  public LocalDateTime getBirthDate() {
    return birthDate;
  }

  @ManyToMany(cascade = { CascadeType.PERSIST })
  @JoinTable(name = "user_benefits",
    joinColumns = { @JoinColumn(name = "user_id") },
    inverseJoinColumns = { @JoinColumn(name = "benefit_id") }
  )
  public Set<Benefit> getBenefits() {
    return benefits;
  }

  @Column(name = "login", nullable = false, unique = true)
  public String getLogin() {
    return login;
  }

  @Column(name = "password", nullable = false)
  public String getPassword() {
    return password;
  }

  @Column(name = "user_role", nullable = false)
  @Enumerated(EnumType.STRING)
  public UserRole getUserRole() {
    return userRole;
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

  public void setBirthDate(LocalDateTime birth) {
    this.birthDate = birth;
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

  public void setUserRole(UserRole role) {
    this.userRole = role;
  }
}

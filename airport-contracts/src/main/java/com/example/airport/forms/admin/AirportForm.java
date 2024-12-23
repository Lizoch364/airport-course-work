package com.example.airport.forms.admin;

import jakarta.validation.constraints.NotBlank;

public class AirportForm{
  private int id;
  private String name;
  private String city;

  public AirportForm(String name, String city) {
    setName(name);
    setCity(city);
  }

  protected AirportForm() {}

  public int getId() {
    return id;
  }

  @NotBlank(message = "Имя обязательно")
  public String getName() {
    return name;
  }

  @NotBlank(message = "Город обязателен")
  public String getCity() {
    return city;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCity(String city) {
    this.city = city;
  }
}

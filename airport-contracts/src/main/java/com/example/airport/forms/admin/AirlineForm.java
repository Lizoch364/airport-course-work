package com.example.airport.forms.admin;

import jakarta.validation.constraints.NotBlank;

public class AirlineForm {
  private int id;
  private String name;

  public AirlineForm(String name) {
    setName(name);
  }

  protected AirlineForm(){}

  public int getId() {
    return id;
  }

  @NotBlank(message = "Имя обязательно")
  public String getName() {
    return name;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }
}


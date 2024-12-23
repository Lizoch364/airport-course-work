package com.example.demo.dto.airport;

import java.io.Serializable;

public class AirportDto implements Serializable{
  private int id;
  private String name;
  private String city;

  public AirportDto() {
    this.id = 0;
    this.name = null;
    this.city = null;
  }

  public AirportDto(int id, String name, String city) {
    this.id = id;
    this.name = name;
    this.city = city;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

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

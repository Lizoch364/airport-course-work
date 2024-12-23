package com.example.demo.dto.airport;

import java.io.Serializable;

public class AirportCreateDto implements Serializable{
  private String name;
  private String city;

  public AirportCreateDto() {
    this.name = null;
    this.city = null;
  }

  public AirportCreateDto(String name, String city) {
    this.name = name;
    this.city = city;
  }

  public String getName() {
    return name;
  }

  public String getCity() {
    return city;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCity(String city) {
    this.city = city;
  }
}

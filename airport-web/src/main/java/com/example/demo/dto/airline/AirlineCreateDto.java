package com.example.demo.dto.airline;

import java.io.Serializable;

public class AirlineCreateDto implements Serializable{
  private String name;

  public AirlineCreateDto () {
    this.name = null;
  }

  public AirlineCreateDto (String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

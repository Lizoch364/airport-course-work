package com.example.demo.dto.airline;

import java.io.Serializable;

public class AirlineUpdateDto  implements Serializable {
  private int id;
  private String name;

  public AirlineUpdateDto () {
    this.name = null;
  }

  public AirlineUpdateDto (int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

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

package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "airports")
public class Airport extends BaseEntity{
  private String name;
  private String city;

  public Airport(String name, String city) {
   setName(name);
   setCity(city);
  }

  protected Airport() {}

  @Column(name = "name", nullable = false)
  public String getName() {
    return name;
  }

  @Column(name = "city", nullable = false)
  public String getCity() {
    return city;
  }

  public void setName(String name) {
    if(name.length() >= 3)
      this.name = name;
  }

  public void setCity(String city) {
    if (city.length() >= 3)
      this.city = city;
  }
}

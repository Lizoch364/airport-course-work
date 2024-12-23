package com.example.demo.dto.airline;

import java.io.Serializable;

public class RatingAirlineDto implements Serializable{
  private int id;
  private String name;
  private int countTicket;

  public RatingAirlineDto (int id, String name, int countTicket) {
    this.id = id;
    this.name = name;
    this.countTicket = countTicket;
  }

  protected RatingAirlineDto(){}
  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getCountTicket() {
    return countTicket;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCountTicket(int rating) {
    this.countTicket = rating;
  }
}

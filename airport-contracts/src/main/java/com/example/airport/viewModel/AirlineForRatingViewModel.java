package com.example.airport.viewModel;

public class AirlineForRatingViewModel {
  private int id;
  private String name;
  private int countTicket;

  public AirlineForRatingViewModel (int id, String name, int countTicket) {
    this.id = id;
    this.name = name;
    this.countTicket = countTicket;
  }

  protected AirlineForRatingViewModel() {}

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

  public void setCountTicket(int countTicket) {
    this.countTicket = countTicket;
  }
}


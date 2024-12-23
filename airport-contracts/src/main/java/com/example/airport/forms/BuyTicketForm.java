package com.example.airport.forms;

public class BuyTicketForm {
  private int flightId;

  public BuyTicketForm(int flightId) {
    this.flightId = flightId;
  }

  public int getFlightId() {
    return flightId;
  }

  public void setFlightId(int flightId) {
    this.flightId = flightId;
  }
}

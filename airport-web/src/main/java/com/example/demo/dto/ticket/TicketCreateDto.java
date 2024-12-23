package com.example.demo.dto.ticket;

public class TicketCreateDto {
  private String passengerLogin;
  private int flightId;

  public TicketCreateDto(String passengerLogin, int flightId) {
    setPassengerLogin(passengerLogin);
    setFlightId(flightId);
  }

  public String getPassengerLogin() {
    return passengerLogin;
  }

  public int getFlightId() {
    return flightId;
  }

  public void setPassengerLogin(String passengerId) {
    this.passengerLogin = passengerId;
  }

  public void setFlightId(int flightId) {
    this.flightId = flightId;
  }

}

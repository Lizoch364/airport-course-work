package com.example.airport.viewModel;

import com.example.airport.viewModel.admin.flight.FlightViewModel;

public class BuyTicketInfoViewModel {
  private int flightId;
  private int passengerId;
  private FlightViewModel flight;
  private double discount;
  private double totalPrice;

  public BuyTicketInfoViewModel(int flightId, int passengerId, FlightViewModel flight, double discount) {
    this.flightId = flightId;
    this.passengerId = passengerId;
    this.flight = flight;
    this.discount = discount;
  }

  protected BuyTicketInfoViewModel() {}

  public int getFlightId() {
    return flightId;
  }

  public int getPassengerId() {
    return passengerId;
  }

  public FlightViewModel getFlight() {
    return flight;
  }

  public double getDiscount() {
    return discount;
  }

  public double getTotalPrice() {
    return totalPrice;
  }

  public void setFlightId(int flightId) {
    this.flightId = flightId;
  }

  public void setPassengerId(int passengerId) {
    this.passengerId = passengerId;
  }

  public void setFlight(FlightViewModel flight) {
    this.flight = flight;
  }

  public void setDiscount(double discount) {
    this.discount = discount;
  }

  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }
}


package com.example.airport.viewModel;

public class UserTicketViewModel {
  private int ticketId;
  private String nameFlight;
  private String departureDate;
  private String arrivalDate;
  private double totalPrice;

  public UserTicketViewModel(int ticketId, String nameFlight, String departureDate, String arrivalDate, double totalPrice) {
    this.ticketId = ticketId;
    this.nameFlight = nameFlight;
    this.departureDate = departureDate;
    this.arrivalDate = arrivalDate;
    this.totalPrice = totalPrice;
  }

  protected UserTicketViewModel() {}

  public int getTicketId() {
    return ticketId;
  }

  public String getNameFlight() {
    return nameFlight;
  }

  public String getDepartureDate() {
    return departureDate;
  }

  public String getArrivalDate() {
    return arrivalDate;
  }

  public double getTotalPrice() {
    return totalPrice;
  }

  public void setTicketId(int ticketId) {
    this.ticketId = ticketId;
  }

  public void setNameFlight(String nameFlight) {
    this.nameFlight = nameFlight;
  }

  public void setDepartureDate(String departureDate) {
    this.departureDate = departureDate;
  }

  public void setArrivalDate(String arrivalDate) {
    this.arrivalDate = arrivalDate;
  }

  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }
}

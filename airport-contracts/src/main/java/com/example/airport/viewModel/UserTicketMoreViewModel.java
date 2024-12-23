package com.example.airport.viewModel;

public class UserTicketMoreViewModel {
  private int ticketId;
  private String flightName;
  private String departureDate;
  private String arrivalDate;
  private String departureAirportName;
  private String departureAirportCity;
  private String arrivalAirportName;
  private String arrivalAirportCity;
  private String airlineName;
  public int initialPrice;
  private double discount;
  private double totalPrice;
  private String status;

  public UserTicketMoreViewModel(int ticketId, String flightName, String departureDate, String arrivalDate, String departureAirportName,
    String departureAirportCity, String arrivalAirportName, String arrivalAirportCity, String airlineName, int initialPrice, double discount, double totalPrice, String status) {
      this.ticketId = ticketId;
      this.flightName = flightName;
      this.departureDate = departureDate;
      this.arrivalDate = arrivalDate;
      this.departureAirportName = departureAirportName;
      this.departureAirportCity = departureAirportCity;
      this.arrivalAirportName = arrivalAirportName;
      this.arrivalAirportCity = arrivalAirportCity;
      this.airlineName = airlineName;
      this.initialPrice = initialPrice;
      this.discount = discount;
      this.totalPrice = totalPrice;
      this.status = status;
    }

  protected UserTicketMoreViewModel() {}

  public int getTicketId() {
    return ticketId;
  }

  public String getFlightName() {
    return flightName;
  }

  public String getDepartureDate() {
    return departureDate;
  }

  public String getArrivalDate() {
    return arrivalDate;
  }

  public String getDepartureAirportName() {
    return departureAirportName;
  }

  public String getDepartureAirportCity() {
    return departureAirportCity;
  }

  public String getArrivalAirportName() {
    return arrivalAirportName;
  }

  public String getArrivalAirportCity() {
    return arrivalAirportCity;
  }

  public String getAirlineName() {
    return airlineName;
  }

  public int getInitialPrice() {
    return initialPrice;
  }

  public double getDiscount() {
    return discount;
  }

  public double getTotalPrice() {
    return totalPrice;
  }

  public String getStatus() {
    return status;
  }


  public void setTicketId(int ticketId) {
    this.ticketId = ticketId;
  }

  public void setFlightName(String flightName) {
    this.flightName = flightName;
  }

  public void setDepartureDate(String departureDate) {
    this.departureDate = departureDate;
  }

  public void setArrivalDate(String arrivalDate) {
    this.arrivalDate = arrivalDate;
  }

  public void setDepartureAirportName(String departureAirportName) {
    this.departureAirportName = departureAirportName;
  }

  public void setDepartureAirportCity(String departureAirportCity) {
    this.departureAirportCity = departureAirportCity;
  }

  public void setArrivalAirportName(String arrivalAirportName) {
    this.arrivalAirportName = arrivalAirportName;
  }

  public void setArrivalAirportCity(String arrivalAirportCity) {
    this.arrivalAirportCity = arrivalAirportCity;
  }

  public void setAirlineName(String airlineName) {
    this.airlineName = airlineName;
  }

  public void setInitialPrice(int initialPrice) {
    this.initialPrice = initialPrice;
  }

  public void setDiscount(double discount) {
    this.discount = discount;
  }

  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}

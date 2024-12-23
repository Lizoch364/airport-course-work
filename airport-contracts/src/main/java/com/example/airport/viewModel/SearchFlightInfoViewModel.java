package com.example.airport.viewModel;

public class SearchFlightInfoViewModel {
  private int flightId;
  private String departureAirportName;
  private String departureAirportCity;
  private String arrivalAirportName;
  private String arrivalAirportCity;
  private String departureDate;
  private String arrivalDate;
  private int initialPrice;

  public SearchFlightInfoViewModel(int flightId, String departureAirportName, String departureAirportCity, String arrivalAirportName, String arrivalAirportCity, String departureDate, String arrivalDate, int initialPrice) {
    this.flightId = flightId;
    this.departureAirportName = departureAirportName;
    this.departureAirportCity = departureAirportCity;
    this.arrivalAirportName = arrivalAirportName;
    this.arrivalAirportCity = arrivalAirportCity;
    this.departureDate = departureDate;
    this.arrivalDate = arrivalDate;
    this.initialPrice = initialPrice;
  }

  protected SearchFlightInfoViewModel() {}

  public int getFlightId() {
    return flightId;
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

  public String getDepartureDate() {
    return departureDate;
  }

  public String getArrivalDate() {
    return arrivalDate;
  }

  public int getInitialPrice() {
    return initialPrice;
  }
  public void setFlightId(int flightId) {
    this.flightId = flightId;
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

  public void setDepartureDate(String departureDate) {
    this.departureDate = departureDate;
  }

  public void setArrivalDate(String arrivalDate) {
    this.arrivalDate = arrivalDate;
  }
  
  public void setInitialPrice(int initialPrice) {
    this.initialPrice = initialPrice;
  }
}

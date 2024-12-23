package com.example.airport.viewModel.admin.flight;

import java.time.LocalDateTime;

public class FlightViewModel {
  private int id;
  private String name;
  private int airlineId;
  private String airlineName;
  private int departureAirportId;
  private String departureAirportName;
  private String departureAirportCity;
  private int arrivalAirportId;
  private String arrivalAirportName;
  private String arrivalAirportCity;
  private LocalDateTime departure;
  private LocalDateTime arrival;
  private int countSeats;
  private int price;

  public FlightViewModel(int id, String name, int airlineId, String airlineName, int departureAirportId, String departureAirportName, String departureAirportCity, int arrivalAirportId, String arrivalAirportName, String arrivalAirportCity, LocalDateTime departure, LocalDateTime arrival, int countSeats, int price) {
    setId(id);
    setName(name);
    setAirlineId(airlineId);
    setAirlineName(airlineName);
    setDepartureAirportId(departureAirportId);
    setDepartureAirportName(departureAirportName);
    setDepartureAirportCity(departureAirportCity);
    setArrivalAirportId(arrivalAirportId);
    setArrivalAirportName(arrivalAirportName);
    setArrivalAirportCity(arrivalAirportCity);
    setDeparture(departure);
    setArrival(arrival);
    setCountSeats(countSeats);
    setPrice(price);
  }

  protected FlightViewModel() {}

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getAirlineId() {
      return airlineId;
  }

  public String getAirlineName() {
    return airlineName;
  }

  public LocalDateTime getDeparture() {
    return departure;
  }

  public int getDepartureAirportId() {
    return departureAirportId;
  }

  public String getDepartureAirportName() {
    return departureAirportName;
  }

  public String getDepartureAirportCity() {
    return departureAirportCity;
  }

  public LocalDateTime getArrival() {
    return arrival;
  }

  public int getArrivalAirportId() {
    return arrivalAirportId;
  }

  public String getArrivalAirportName() {
    return arrivalAirportName;
  }

  public String getArrivalAirportCity() {
    return arrivalAirportCity;
  }

  public int getCountSeats() {
    return countSeats;
  }

  public int getPrice() {
    return price;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setAirlineId(int airlineId) {
    this.airlineId = airlineId;
  }

  public void setAirlineName(String airlineName) {
    this.airlineName = airlineName;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDeparture(LocalDateTime departure) {
    this.departure = departure;
  }

  public void setDepartureAirportId(int departureAirportId) {
    this.departureAirportId = departureAirportId;
  }

  public void setDepartureAirportName(String departureAirportName) {
    this.departureAirportName = departureAirportName;
  }

  public void setDepartureAirportCity(String departureAirportCity) {
    this.departureAirportCity = departureAirportCity;
  }

  public void setArrival(LocalDateTime arrival) {
    this.arrival = arrival;
  }

  public void setArrivalAirportId(int arrivalAirportId) {
    this.arrivalAirportId = arrivalAirportId;
  }

  public void setArrivalAirportName(String arrivalAirportName) {
    this.arrivalAirportName = arrivalAirportName;
  }

  public void setArrivalAirportCity(String arrivalAirportCity) {
    this.arrivalAirportCity = arrivalAirportCity;
  }

  public void setCountSeats(int countSeats) {
    this.countSeats = countSeats;
  }

  public void setPrice(int price) {
    this.price = price;
  }
}

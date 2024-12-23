package com.example.demo.dto.flight;

import java.time.LocalDateTime;

public class FlightUpdateDto {
  private int id;
  private String name;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private int departureAirportId;
  private int arrivalAirportId;
  private int airlineId;
  private int countSeats;
  private int price;

  public FlightUpdateDto(int id, String name, LocalDateTime startDate, LocalDateTime endDate, int departureAirportId, int arrivalAirportId, int airlineId, int countSeats, int price) {
    setId(id);
    setName(name);
    setStartDate(startDate);
    setEndDate(endDate);
    setDepartureAirportId(departureAirportId);
    setArrivalAirportId(arrivalAirportId);
    setAirlineId(airlineId);
    setCountSeats(countSeats);
    setPrice(price);
  }

  protected FlightUpdateDto() {}

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public LocalDateTime getStartDate() {
    return startDate;
  }

  public LocalDateTime getEndDate() {
    return endDate;
  }

  public int getDepartureAirportId() {
    return departureAirportId;
  }

  public int getArrivalAirportId() {
    return arrivalAirportId;
  }

  public int getAirlineId() {
    return airlineId;
  }

  public int getCountSeats() {
    return countSeats;
  }

  public int getPrice() {
    return price;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setStartDate(LocalDateTime startDate) {
    this.startDate = startDate;
  }

  public void setEndDate(LocalDateTime endDate) {
    this.endDate = endDate;
  }
  public void setDepartureAirportId(int departureAirportId) {
    this.departureAirportId = departureAirportId;
  }

  public void setArrivalAirportId(int arrivalAirportId) {
    this.arrivalAirportId = arrivalAirportId;
  }

  public void setAirlineId(int airlineId) {
    this.airlineId = airlineId;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setCountSeats(int countSeats) {
    this.countSeats = countSeats;
  }

  public void setPrice(int price) {
    this.price = price;
  }
}

package com.example.demo.dto.flight;

import java.time.LocalDateTime;

import com.example.demo.domain.Airline;
import com.example.demo.domain.Airport;
import com.fasterxml.jackson.annotation.JsonFormat;

public class FlightDto {
  private int id;
  private String name;
  private Airline airline;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime startDate;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime endDate;
  
  private Airport departureAirport;
  private Airport arrivalAirport;
  private int countSeats;
  private int price;

  public FlightDto(int id, String name, Airline airline, Airport departureAirport, Airport arrivalAirport, LocalDateTime startDate, LocalDateTime endDate, int countSeat, int price) {
    this.id = id;
    this.name = name;
    this.airline = airline;
    this.departureAirport = departureAirport;
    this.arrivalAirport = arrivalAirport;
    this.startDate = startDate;
    this.endDate = endDate;
    this.countSeats = countSeat;
    this.price = price;
  }

  protected FlightDto() {}

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

  public Airport getDepartureAirport() {
    return departureAirport;
  }

  public Airport getArrivalAirport() {
    return arrivalAirport;
  }

  public Airline getAirline() {
    return airline;
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
  public void setDepartureAirport(Airport departureAirport) {
    this.departureAirport = departureAirport;
  }

  public void setArrivalAirport(Airport arrivalAirport) {
    this.arrivalAirport = arrivalAirport;
  }

  public void setAirline(Airline airline) {
    this.airline = airline;
  }

  public void setCountSeats(int countSeat) {
    this.countSeats = countSeat;
  }

  public void setPrice(int price) {
    this.price = price;
  }
  public void setId(int id) {
    this.id = id;
  }
}

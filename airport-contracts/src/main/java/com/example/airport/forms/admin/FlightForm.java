package com.example.airport.forms.admin;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class FlightForm{
  private int id;
  private String name;
  private int airlineId;
  private int departureAirportId;
  private int arrivalAirportId;
  private String departure;
  private String arrival;
  private int countSeats;
  private int price;

  public FlightForm(String name, int airlineId, int departureAirportId, int arrivalAirportId, String departure, String arrival, int countSeats, int price) {
    this.name = name;
    this.airlineId = airlineId;
    this.departureAirportId = departureAirportId;
    this.arrivalAirportId = arrivalAirportId;
    this.departure = departure;
    this.arrival = arrival;
    this.countSeats = countSeats;
    this.price = price;
  }

  protected FlightForm() {}

  public int getId() {
    return id;
  }


  @NotBlank(message = "Имя обязательно")
  public String getName() {
    return name;
  }

  @NotNull(message = "Авиакомпания обязательна")
  public int getAirlineId() {
    return airlineId;
  }

  @NotNull(message = "Аэропорт вылета обязателен")
  public int getDepartureAirportId() {
    return departureAirportId;
  }

  @NotNull(message = "Аэропорт прилета обязателен")
  public int getArrivalAirportId() {
    return arrivalAirportId;
  }

  @NotBlank(message = "Дата вылета обязательна")
  public String getDeparture() {
    return departure;
  }

  @NotBlank(message = "Дата прилета обязательна")
  public String getArrival() {
    return arrival;
  }

  @NotNull
  @Min(value = 0, message = "Количество мест на рейсе должно быть больше 0")
  public int getCountSeats() {
    return countSeats;
  }


  @NotNull
  @Min(value = 0, message = "Стоимость должна быть больше 0")
  public int getPrice() {
    return price;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAirlineId(int airlineId) {
    this.airlineId = airlineId;
  }

  public void setDepartureAirportId(int departureAirportId) {
    this.departureAirportId = departureAirportId;
  }

  public void setArrivalAirportId(int arrivalAirportId) {
    this.arrivalAirportId = arrivalAirportId;
  }

  public void setDeparture(String departure) {
    this.departure = departure;
  }

  public void setArrival(String arrival) {
    this.arrival = arrival;
  }

  public void setCountSeats(int countSeats) {
    this.countSeats = countSeats;
  }

  public void setPrice(int price) {
    this.price = price;
  }
}

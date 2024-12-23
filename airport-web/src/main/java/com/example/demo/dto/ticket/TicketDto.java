package com.example.demo.dto.ticket;

import com.example.demo.domain.Flight;
import com.example.demo.domain.User;

public class TicketDto {
  private int id;
  private User passenger;
  private Flight flight;
  private double discount;
  private int initialPrice;
  private String ticketStatus;
  private double totalPrice;

  public TicketDto(int id, User passenger, Flight flight, int discount, int initialPrice, String ticketStatus) {
    setId(id);
    setPassenger(passenger);
    setFlight(flight);
    setDiscount(discount);
    setInitialPrice(initialPrice);
    setTicketStatus(ticketStatus);
  }

  protected TicketDto() {}

  public int getId() {
    return id;
  }

  public User getPassenger() {
    return passenger;
  }

  public Flight getFlight() {
    return flight;
  }

  public double getDiscount() {
    return discount;
  }

  public int getInitialPrice() {
    return initialPrice;
  }

  public String getTicketStatus() {
    return ticketStatus;
  }

  public double  getTotalPrice() {
    return totalPrice;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setPassenger(User passenger) {
    this.passenger = passenger;
  }

  public void setFlight(Flight flight) {
    this.flight = flight;
  }

  public void setDiscount(double discount) {
    this.discount = discount;
  }

  public void setInitialPrice(int initialPrice) {
    this.initialPrice = initialPrice;
  }

  public void setTicketStatus(String ticketStatus) {
    this.ticketStatus = ticketStatus;
  }

  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }
}

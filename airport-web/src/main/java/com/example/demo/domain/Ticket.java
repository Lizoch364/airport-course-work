package com.example.demo.domain;

import com.example.demo.domain.enums.TicketStatus;

import jakarta.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket extends BaseEntity {
  private User user;
  private Flight flight;
  private double discount;
  private int initialPrice;
  private TicketStatus ticketStatus;

  public Ticket(User user, Flight flight, int ticketPrice, double discount) {
    setUser(user);
    setFlight(flight);
    setInitialPrice(ticketPrice);

    this.initialPrice = ticketPrice;
    this.discount = discount;
    this.ticketStatus = TicketStatus.Payed;
  }

  protected Ticket() {}

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  public User getUser() {
    return user;
  }

  @ManyToOne
  @JoinColumn(name = "flight_id", nullable = false)
  public Flight getFlight() {
    return flight;
  }

  @Column(name = "initial_price", nullable = false)
  public int getInitialPrice() {
    return initialPrice;
  }

  @Column(name = "ticket_status", nullable = false)
  @Enumerated(EnumType.STRING)
  public TicketStatus getTicketStatus() {
    return ticketStatus;
  }

  @Column(name = "discount")
  public double getDiscount() {
    return discount;
  }

  public int calculateTotalPrice() {
    return (int)(initialPrice * (1 - discount));
  }

  public void decline() {
    if (ticketStatus != TicketStatus.Declined) {
      setTicketStatus(TicketStatus.Declined);
    }
  }

  public void setUser(User user) {
    this.user = user;
  }

  public void setFlight(Flight flight) {
    this.flight = flight;
  }

  public void setInitialPrice(int price) {
    this.initialPrice = price;
  }

  public void setDiscount(double discount) {
    this.discount = discount;
  }

  protected void setTicketStatus(TicketStatus status) {
    this.ticketStatus = status;
  }
}

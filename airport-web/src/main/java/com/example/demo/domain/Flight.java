package com.example.demo.domain;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "flights")
public class Flight extends BaseEntity {
  private String name;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private Airport departureAirport;
  private Airport arrivalAirport;
  private Airline airline;
  private int countSeats;
  private int price;
  private Set<Ticket> tickets;

  public Flight(String name, LocalDateTime startDate, LocalDateTime endDate, Airport departureAirport, Airport arrivalAirport, Airline airline, int countSeats, int price) {
    setName(name);
    setStartDate(startDate);
    setEndDate(endDate);
    setDepartureAirport(departureAirport);
    setArrivalAirport(arrivalAirport);
    setAirline(airline);
    setCountSeats(countSeats);
    setPrice(price);
  }

  protected Flight() {}

  @Column(name = "name", nullable = false)
  public String getName() {
    return name;
  }

  @Column(name = "start_date", nullable = false)
  public LocalDateTime getStartDate() {
    return startDate;
  }

  @Column(name = "end_date", nullable = false)
  public LocalDateTime getEndDate() {
    return endDate;
  }

  @ManyToOne
  @JoinColumn(name = "departure_airport_id", nullable = false)
  public Airport getDepartureAirport() {
    return departureAirport;
  }

  @ManyToOne
  @JoinColumn(name = "arrival_airport_id", nullable = false)
  public Airport getArrivalAirport() {
    return arrivalAirport;
  }

  @ManyToOne
  @JoinColumn(name = "airline_id", nullable = false)
  public Airline getAirline() {
    return airline;
  }

  @Column(name = "count_seats", nullable = false)
  public int getCountSeats() {return countSeats; }

  @OneToMany(mappedBy = "flight")
  public Set<Ticket> getTickets() {
    return tickets;
  }

  @Column(name = "price", nullable = false)
  public int getPrice() {
    return price;
  }

  public void setName(String name) {
    if (name.length() >= 3) {
      this.name = name;
    }
  }

  public void setStartDate(LocalDateTime startDate) {
    if (getEndDate() != null) {
      if (startDate.isAfter(endDate)) {
        throw new RuntimeException("Дата вылета не может быть позднее, чем дата прилета");
      }
    }

    this.startDate = startDate;
  }

  public void setEndDate(LocalDateTime endDate) {
    if (getStartDate() != null ) {
      if(endDate.isBefore(getStartDate())) {
        throw new RuntimeException("Дата прилета не может быть раньше, чем дата вылета");
      }
    }
    
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

  public void setCountSeats(int countSeats) {
    if (countSeats > 0) {
      this.countSeats = countSeats;
    }
  }

  public void setPrice(int price) {
    if (price >= 0){
      this.price = price;
    }
  }

  public void setTickets(Set<Ticket> tickets) {
    this.tickets = tickets;
  }
}

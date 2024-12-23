package com.example.airport.viewModel.admin.ticket;

public class TicketViewModel {
  private int id;
  private int userId;
  private String userSurname;
  private String userName;
  private String userLastname;
  private int flightId;
  private String flightName;
  private double discount;
  private int initialPrice;
  private String ticketStatus;
  private double totalPrice;

  public TicketViewModel(int id, int userId, String userSurname, String userName, String userLastname, int flightId, double discount, int initialPrice, String ticketStatus) {
    this.id = id;
    this.userId = userId;
    this.userSurname = userSurname;
    this.userName = userName;
    this.userLastname = userLastname;
    this.flightId = flightId;
    this.discount = discount;
    this.initialPrice = initialPrice;
    this.ticketStatus = ticketStatus;
    this.totalPrice = totalPrice;
  }

  protected TicketViewModel () {}

  public int getId() {
    return id;
  }

  public int getUserId() {
    return userId;
  }

  public String getUserSurname() {
    return userSurname;
  }

  public String getUserName() {
    return userName;
  }

  public String getUserLastname() {
    return userLastname;
  }

  public int getFlightId() {
    return flightId;
  }

  public String getFlightName() {
    return flightName;
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

  public double getTotalPrice() {
    return totalPrice;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public void setUserSurname(String userSurname) {
    this.userSurname = userSurname;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setUserLastname(String userLastname) {
    this.userLastname = userLastname;
  }

  public void setFlightId(int flightId) {
    this.flightId = flightId;
  }

  public void setFlightName(String flightName) {
    this.flightName = flightName;
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

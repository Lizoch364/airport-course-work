package com.example.demo.domain.enums;

public enum TicketStatus {
  Payed(1), Declined(2);

  private int value;

  TicketStatus(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}

package com.example.demo.domain.enums;

public enum UserRole {
  Admin(1), User(2);

  private int value;

  UserRole(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}

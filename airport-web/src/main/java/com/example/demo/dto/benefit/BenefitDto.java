package com.example.demo.dto.benefit;

public class BenefitDto {
  private String name;
  private int discountMultiplier;

  public BenefitDto() {
    this.name = null;
    this.discountMultiplier = 0;
  }

  public BenefitDto(String name, int index) {
    this.name = name;
    this.discountMultiplier = index;
  }

  public String getName() {
    return name;
  }

  public int getDiscountMultiplier() {
    return discountMultiplier;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDiscountMultiplier(int discountMultiplier) {
    this.discountMultiplier = discountMultiplier;
  }
}

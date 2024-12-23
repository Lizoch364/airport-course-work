package com.example.demo.dto.benefit;

public class BenefitUpdateDto {
  private int id;
  private String name;
  private int discountMultiplier;

  public BenefitUpdateDto() {
    this.id = 0;
    this.name = null;
    this.discountMultiplier = 0;
  }

  public BenefitUpdateDto(int id, String name, int index) {
    this.id = id;
    this.name = name;
    this.discountMultiplier = index;
  }

  public int getId() {
    return id;
  }


  public String getName() {
    return name;
  }

  public int getDiscountMultiplier() {
    return discountMultiplier;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDiscountMultiplier(int discountMultiplier) {
    this.discountMultiplier = discountMultiplier;
  }
}

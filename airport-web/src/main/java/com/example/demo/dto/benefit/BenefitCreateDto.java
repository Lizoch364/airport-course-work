package com.example.demo.dto.benefit;

public class BenefitCreateDto {
  private int id;
  private String name;
  private int discountMultiplier;

  public BenefitCreateDto() {
    this.id = 0;
    this.name = null;
    this.discountMultiplier = 0;
  }

  public BenefitCreateDto(int id, String name, int index) {
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

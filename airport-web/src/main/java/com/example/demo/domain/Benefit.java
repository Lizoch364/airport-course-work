package com.example.demo.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "benefits")
public class Benefit extends BaseEntity implements Comparable<Benefit> {
  private String name;
  private double discountMultiplier;
  private Set<User> users;

  public Benefit(String name, double index) {
    setName(name);
    setDiscountMultiplier(index);
    setUsers(new HashSet<>());
  }

  protected Benefit() {}

  @Column(name = "name", nullable = false)
  public String getName() {
    return name;
  }

  @Column(name = "discount_multiplier", nullable = false)
  public double getDiscountMultiplier() {
    return discountMultiplier;
  }

  @ManyToMany(mappedBy = "benefits")
  public Set<User> getUsers() {
    return users;
  }

  public void setName(String name) {
    if (name.length() >= 3)
      this.name = name;
  }

  public void setDiscountMultiplier(double index) {
    if (index > 0)
      this.discountMultiplier = index;
  }

  public void setUsers(Set<User> users) {
    this.users = users;
  }

  @Override
  public int compareTo(Benefit other) {
    return Double.compare(discountMultiplier, other.getDiscountMultiplier());
  }
}

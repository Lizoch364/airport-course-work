package com.example.demo.services;

import java.util.Set;

import com.example.demo.domain.Benefit;

public interface BenefitService {
  void recalculateUserBenefits(int userId);
  Benefit getMaxBenefit(Set<Benefit> benefits);
  Benefit findMaxBenefitByUserId(int userId);
}

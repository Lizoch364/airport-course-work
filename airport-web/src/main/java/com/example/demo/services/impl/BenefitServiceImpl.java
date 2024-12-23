package com.example.demo.services.impl;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Benefit;
import com.example.demo.domain.User;
import com.example.demo.repository.BenefitRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.BenefitService;

@Service
public class BenefitServiceImpl implements BenefitService{
  private BenefitRepository benefitRepository;
  private UserRepository userRepository;

  @Override
  public void recalculateUserBenefits(int userId) {
    User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Пользователь с id = " + userId + "не найден"));

    Map<String, Benefit> benefitsMap = new HashMap<>();
    List<Benefit> benefits = benefitRepository.findAll();
    NavigableSet<Benefit> benefitsForUser = new TreeSet<>((left, right) -> right.compareTo(left));

    for (Benefit benefit : benefits) {
      benefitsMap.put(benefit.getName(), benefit);
    }

    int age = Period.between(user.getBirthDate().toLocalDate(), LocalDate.now()).getYears();

    if (age >= 14 && age <= 35) {
      benefitsForUser.add(benefitsMap.get("Youth"));
    }

    if (age >= 55) {
      benefitsForUser.add(benefitsMap.get("Elderly"));
    }

    if (benefitsForUser.isEmpty()) {
      benefitsForUser.add(benefitsMap.get("Nothing"));
    }

    user.setBenefits(benefitsForUser);
    userRepository.update(user);
  }

  @Override
  public Benefit findMaxBenefitByUserId(int userId) {
    recalculateUserBenefits(userId);

    return getMaxBenefit(userRepository.findById(userId).get().getBenefits());
  }

  @Override
  public Benefit getMaxBenefit(Set<Benefit> benefits) {
    NavigableSet<Benefit> sortedBenefits = new TreeSet<>((l, r) -> r.compareTo(l));

    for (var b : benefits) {
      sortedBenefits.add(b);
    }

    return sortedBenefits.pollFirst();
  }

  @Autowired
  public void setBenefitRepository(BenefitRepository benefitRepository) {
    this.benefitRepository = benefitRepository;
  }

  @Autowired
  public void setUserRepository(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
}

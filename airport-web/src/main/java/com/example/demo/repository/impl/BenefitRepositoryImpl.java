package com.example.demo.repository.impl;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.Benefit;
import com.example.demo.repository.BenefitRepository;
import com.example.demo.repository.baseRepository.BaseRepositoryImpl;

@Repository
public class BenefitRepositoryImpl extends BaseRepositoryImpl<Benefit> implements BenefitRepository {
  public BenefitRepositoryImpl() {
    super(Benefit.class);
  }
}

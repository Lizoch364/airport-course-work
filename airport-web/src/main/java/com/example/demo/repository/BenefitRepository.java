package com.example.demo.repository;

import com.example.demo.domain.Benefit;
import com.example.demo.repository.baseRepository.CreateRepository;
import com.example.demo.repository.baseRepository.GetRepository;
import com.example.demo.repository.baseRepository.UpdateRepository;

public interface BenefitRepository extends CreateRepository<Benefit>, GetRepository<Benefit>, UpdateRepository<Benefit>{
}

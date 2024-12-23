package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.Airline;
import com.example.demo.repository.baseRepository.CreateRepository;
import com.example.demo.repository.baseRepository.GetRepository;
import com.example.demo.repository.baseRepository.UpdateRepository;

public interface AirlineRepository extends CreateRepository<Airline>, GetRepository<Airline>, UpdateRepository<Airline>{
}

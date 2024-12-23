package com.example.demo.repository.impl;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.Airline;
import com.example.demo.repository.AirlineRepository;
import com.example.demo.repository.baseRepository.BaseRepositoryImpl;

@Repository
public class AirlineRepositoryImpl extends BaseRepositoryImpl<Airline> implements AirlineRepository{
  public AirlineRepositoryImpl(){
    super(Airline.class);
  }
}

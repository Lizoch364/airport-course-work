package com.example.demo.repository.impl;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.Airport;
import com.example.demo.repository.AirportRepository;
import com.example.demo.repository.baseRepository.BaseRepositoryImpl;

@Repository
public class AirportRepositoryImpl extends BaseRepositoryImpl<Airport> implements AirportRepository{
  public AirportRepositoryImpl(){
    super(Airport.class);
  }
  @Override
  public Optional<Airport> findByCity(String city) {
    try {
      return Optional.ofNullable(
        getEntityManager().createQuery(
        "SELECT a FROM Airport a WHERE a.city = :city",
        Airport.class)
        .setParameter("city", city)
        .getSingleResult()
        );
    } catch (Exception e) {
      return Optional.empty();
    }
  }
}

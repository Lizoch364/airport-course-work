package com.example.demo.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.Flight;
import com.example.demo.repository.FlightRepository;
import com.example.demo.repository.baseRepository.BaseRepositoryImpl;

@Repository
public class FlightRepositoryImpl extends BaseRepositoryImpl<Flight> implements FlightRepository{
  public FlightRepositoryImpl() {
    super(Flight.class);
  }

  @Override
  public List<Flight> findAllByDepartureAirportAndArrivalAirport(int departureAirportId, int arrivalAirportId) {
    return getEntityManager().createQuery("""
        select f from Flight f
        join f.departureAirport da
        join f.arrivalAirport aa
        where da.id = :departure_airport_id and aa.id = :arrival_airport_id
      """, Flight.class)
    .setParameter("departure_airport_id", departureAirportId)
    .setParameter("arrival_airport_id", arrivalAirportId)
    .getResultList();
  }
}

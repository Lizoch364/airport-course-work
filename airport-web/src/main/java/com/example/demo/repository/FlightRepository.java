package com.example.demo.repository;

import java.util.List;

import com.example.demo.domain.Airport;
import com.example.demo.domain.Flight;
import com.example.demo.repository.baseRepository.CreateRepository;
import com.example.demo.repository.baseRepository.GetRepository;
import com.example.demo.repository.baseRepository.UpdateRepository;

public interface FlightRepository extends CreateRepository<Flight>, GetRepository<Flight>, UpdateRepository<Flight>{
  public List<Flight> findAllByDepartureAirportAndArrivalAirport(int departureAirportId, int arrivalAirportId);
}

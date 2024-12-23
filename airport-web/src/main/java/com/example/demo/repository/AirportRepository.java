package com.example.demo.repository;

import java.util.Optional;

import com.example.demo.domain.Airport;
import com.example.demo.repository.baseRepository.CreateRepository;
import com.example.demo.repository.baseRepository.GetRepository;
import com.example.demo.repository.baseRepository.UpdateRepository;

public interface AirportRepository extends CreateRepository<Airport>, GetRepository<Airport>, UpdateRepository<Airport>{
    Optional<Airport> findByCity(String city);

}

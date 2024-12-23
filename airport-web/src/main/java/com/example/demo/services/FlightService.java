package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.flight.FlightCreateDto;
import com.example.demo.dto.flight.FlightDto;
import com.example.demo.dto.flight.FlightUpdateDto;

public interface FlightService {
    List<FlightDto> findAll();
    FlightDto findById(int id);
    FlightDto create(FlightCreateDto dto);
    FlightDto update(FlightUpdateDto dto);
    List<FlightDto> searchFlightByParam(String cityDeparture, String cityArrival);
    List<FlightDto> filterAvailableFlight(List<FlightDto> flights);
}

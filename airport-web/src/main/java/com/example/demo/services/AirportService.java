package com.example.demo.services;

import com.example.demo.dto.airport.AirportCreateDto;
import com.example.demo.dto.airport.AirportDto;
import com.example.demo.dto.airport.AirportUpdateDto;

import java.util.List;

public interface AirportService {
    List<AirportDto> findAll();
    AirportDto findById(int id);
    AirportDto create(AirportCreateDto dto);
    AirportDto update(AirportUpdateDto dto);
}

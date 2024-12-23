package com.example.demo.services;

import com.example.demo.dto.airline.AirlineCreateDto;
import com.example.demo.dto.airline.AirlineDto;
import com.example.demo.dto.airline.AirlineUpdateDto;
import com.example.demo.dto.airline.RatingAirlineDto;

import java.util.List;

public interface AirlineService {
    List<AirlineDto> findAll();
    AirlineDto findById(int id);
    AirlineDto create(AirlineCreateDto dto);
    AirlineDto update(AirlineUpdateDto dto);
    List<RatingAirlineDto> getTopNAirlinesByRating();
}

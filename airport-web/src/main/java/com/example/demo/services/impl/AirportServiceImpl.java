package com.example.demo.services.impl;

import com.example.demo.domain.Airport;
import com.example.demo.dto.airport.AirportCreateDto;
import com.example.demo.dto.airport.AirportDto;
import com.example.demo.dto.airport.AirportUpdateDto;
import com.example.demo.repository.AirportRepository;
import com.example.demo.services.AirportService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.cache.annotation.EnableCaching;

@Service
@EnableCaching
public class AirportServiceImpl implements AirportService{
    private AirportRepository airportRepository;

    private ModelMapper modelMapper;
    @Override
    @Cacheable(value = "airports", key = "'allAirports'")
    public List<AirportDto> findAll() {
        return airportRepository.findAll().stream().map(airport -> modelMapper.map(airport, AirportDto.class)).toList();
    }

    @Override
    public AirportDto findById(int id) {
        Optional<Airport> airport = airportRepository.findById(id);
        if (airport.isEmpty()) {
            throw new RuntimeException("Аэропорт с id = " + id + " не найден");
        }

        return modelMapper.map(airport.get(), AirportDto.class);
    }

    @Override
    @Caching(evict = @CacheEvict(cacheNames = "airports", allEntries = true))
    public AirportDto create(AirportCreateDto dto) {
        Airport airport = new Airport(dto.getName(), dto.getCity());
        var result = airportRepository.save(airport);

        if (result == null) {
            throw new RuntimeException("Аэропорт не создан");
        }

        return modelMapper.map(airport, AirportDto.class);
    }

    @Override
    @Caching(evict = @CacheEvict(cacheNames = "airports", allEntries = true))
    public AirportDto update(AirportUpdateDto dto) {
        Optional<Airport> airport = airportRepository.findById(dto.getId());

        if (airport.isEmpty()) {
            throw new RuntimeException("Аэропорт с id = " + dto.getId() + " не найден");
        }

        Airport updatedAirport = airport.get();

        updatedAirport.setName(dto.getName());
        updatedAirport.setCity(dto.getCity());

        airportRepository.update(updatedAirport);
        return modelMapper.map(airport.get(), AirportDto.class);
    }

    @Autowired
    public void setAirportRepository(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
      this.modelMapper = modelMapper;
    }
}

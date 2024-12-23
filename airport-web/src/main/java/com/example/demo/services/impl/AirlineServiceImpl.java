package com.example.demo.services.impl;

import com.example.demo.domain.Airline;
import com.example.demo.dto.airline.AirlineCreateDto;
import com.example.demo.dto.airline.AirlineDto;
import com.example.demo.dto.airline.AirlineUpdateDto;
import com.example.demo.dto.airline.RatingAirlineDto;
import com.example.demo.repository.AirlineRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.services.AirlineService;
import com.example.demo.utils.RatingAirlineComparator;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.Caching;

@Service
@EnableCaching
public class AirlineServiceImpl implements AirlineService {
    private AirlineRepository airlineRepository;
    private TicketRepository ticketRepository;

    private ModelMapper modelMapper;

    @Override
    @Cacheable(value = "airlines", key = "'allAirlines'")
    public List<AirlineDto> findAll() {
        List<Airline> airlines = airlineRepository.findAll();
        return airlines.stream().map(airline -> modelMapper.map(airline, AirlineDto.class)).toList();
    }

    @Override
    public AirlineDto findById(int id) {
        Optional<Airline> airline = airlineRepository.findById(id);
        if (airline.isEmpty()) {
            throw new RuntimeException("Авиакомпания с " + id + " не найдена");
        }

        return modelMapper.map(airline, AirlineDto.class);
    }

    @Override
    public AirlineDto create(AirlineCreateDto dto) {
        Airline airline = new Airline(dto.getName());
        var result = airlineRepository.save(airline);

        if (result == null) {
            throw new RuntimeException("Авиакомпания не создана");
        }

        return modelMapper.map(airline, AirlineDto.class);
    }

    @Override
    public AirlineDto update(AirlineUpdateDto dto) {
        Optional<Airline> airline = airlineRepository.findById(dto.getId());

        if (airline.isEmpty()) {
            throw new RuntimeException("Авиакомпания с " + dto.getId() + " не найдена");
        }

        Airline updateAirline = airline.get();

        updateAirline.setName(dto.getName());

        airlineRepository.update(updateAirline);

        return modelMapper.map(airline, AirlineDto.class);
    }

    @Override
    public List<RatingAirlineDto> getTopNAirlinesByRating() {
        List<Airline> airlines = airlineRepository.findAll();
        List<RatingAirlineDto> list = new ArrayList<>(airlines.size());

        for (var airline : airlines) {
            int countTicket = ticketRepository.countAllTicketsByAirlineId(airline.getId());
            list.add(new RatingAirlineDto(airline.getId(), airline.getName(), countTicket));
        }

        list.sort(new RatingAirlineComparator());

        return list;
    }

    @Autowired
    public void setAirportRepository(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    @Autowired
    public void setTicketRepository(TicketRepository ticketRepository) {
      this.ticketRepository = ticketRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
      this.modelMapper = modelMapper;
    }
}

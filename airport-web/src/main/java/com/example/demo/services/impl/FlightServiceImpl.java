package com.example.demo.services.impl;

import java.util.ArrayList;

import com.example.demo.domain.Flight;
import com.example.demo.dto.flight.FlightCreateDto;
import com.example.demo.dto.flight.FlightDto;
import com.example.demo.dto.flight.FlightUpdateDto;
import com.example.demo.repository.AirlineRepository;
import com.example.demo.repository.AirportRepository;
import com.example.demo.repository.FlightRepository;
import com.example.demo.services.FlightService;

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
// @EnableCaching
public class FlightServiceImpl implements FlightService {
    private FlightRepository flightRepository;
    private AirlineRepository airlineRepository;
    private AirportRepository airportRepository;

    private ModelMapper modelMapper;

    @Override
    // @Cacheable("flights")
    public List<FlightDto> findAll() {
        return flightRepository.findAll().stream().map((flight) -> modelMapper.map(flight, FlightDto.class)).toList();
    }

    @Override
    public FlightDto findById(int id) {
        Optional<Flight> flight = flightRepository.findById(id);

        if (flight.isEmpty()) {
            throw new RuntimeException("Рейс не с id = " + id + " найден");
        }

        return modelMapper.map(flight.get(), FlightDto.class);
    }

    @Override
    // @Caching(evict = @CacheEvict(cacheNames = "flights", allEntries = true))
    public FlightDto create(FlightCreateDto dto) {
        var airline = airlineRepository.findById(dto.getAirlineId());
        if (airline.isEmpty()) {
            throw new RuntimeException("Авиакомпания с id = " + dto.getAirlineId() + " не найдена");
        }

        var departureAirport = airportRepository.findById(dto.getDepartureAirportId());
        if (departureAirport.isEmpty()) {
            throw new RuntimeException("Аэропорт отправления с id = " + dto.getDepartureAirportId() + " не найден");
        }

        var arrivalAirport = airportRepository.findById(dto.getArrivalAirportId());
        if (arrivalAirport.isEmpty()) {
            throw new RuntimeException("Аэропорт прибытия с id = " + dto.getArrivalAirportId() + " не найден");
        }

        System.out.println(arrivalAirport.get().getId());

        Flight flight = new Flight(dto.getName(), dto.getStartDate(), dto.getEndDate(), departureAirport.get(), arrivalAirport.get(), airline.get(), dto.getCountSeats(), dto.getPrice());
        System.out.println(flight.getArrivalAirport().getId());

        var result = flightRepository.save(flight);

        if (result == null) {
            throw new RuntimeException("Рейс не создан");
        }

        return modelMapper.map(flight, FlightDto.class);
    }

    @Override
    // @Caching(evict = @CacheEvict(cacheNames = "flights", allEntries = true))
    public FlightDto update(FlightUpdateDto dto) {
        Optional<Flight> flight = flightRepository.findById(dto.getId());

        if (flight.isEmpty()) {
            throw new RuntimeException("Рейс с id = " + dto.getId() + " не найден");
        }

        Flight updatedFlight = flight.get();

        if (dto.getAirlineId() > 0) {
            var airline = airlineRepository.findById(dto.getAirlineId());
            if (airline.isEmpty()) {
                throw new RuntimeException("Авиакомпания с id = " + dto.getAirlineId() + " не найдена");
            }
            updatedFlight.setAirline(airline.get());
        }

        if (dto.getDepartureAirportId() > 0) {
            var departureAirport = airportRepository.findById(dto.getDepartureAirportId());
            if (departureAirport.isEmpty()) {
                throw new RuntimeException("Аэропорт отправления с id = " + dto.getDepartureAirportId() + " не найден");
            }
            updatedFlight.setDepartureAirport(departureAirport.get());
        }

        if (dto.getArrivalAirportId() > 0) {
            var arrivalAirport = airportRepository.findById(dto.getArrivalAirportId());
            if (arrivalAirport.isEmpty()) {
                throw new RuntimeException("Аэропорт прибытия с id = " + dto.getArrivalAirportId() + " не найден");
            }
            updatedFlight.setArrivalAirport(arrivalAirport.get());
        }

        updatedFlight.setName(dto.getName());
        updatedFlight.setStartDate(dto.getStartDate());
        updatedFlight.setEndDate(dto.getEndDate());
        updatedFlight.setCountSeats(dto.getCountSeats());
        updatedFlight.setPrice(dto.getPrice());

        flightRepository.update(updatedFlight);

        return modelMapper.map(updatedFlight, FlightDto.class);
    }

    @Override
    public List<FlightDto> searchFlightByParam(String cityDeparture, String cityArrival) {
        var departureAirport = airportRepository.findByCity(cityDeparture);

        if (departureAirport.isEmpty()) {
            throw new RuntimeException("Аэропорт отправления с названием " + cityDeparture + " не найден");
        }

        var arrivalAirport = airportRepository.findByCity(cityArrival);

        if (arrivalAirport.isEmpty()) {
            throw new RuntimeException("Аэропорт прибытия с названием " + cityArrival + " не найден");
        }
        return flightRepository.findAllByDepartureAirportAndArrivalAirport(departureAirport.get().getId(), arrivalAirport.get().getId()).stream().map(
            flight -> modelMapper.map(flight, FlightDto.class)).toList();
    }

    @Autowired
    public void setFlightRepository(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Autowired
    public void setAirlineRepository(AirlineRepository airlineRepository) {
      this.airlineRepository = airlineRepository;
    }

    @Autowired
    public void setAirportRepository(AirportRepository airportRepository) {
      this.airportRepository = airportRepository;
    }

    @Override
    public List<FlightDto> filterAvailableFlight(List<FlightDto> flights) {
        List<FlightDto> result = new ArrayList<FlightDto>();

        for(var flightDto : flights) {
            var flight = flightRepository.findById(flightDto.getId()).get();
            if(flight.getTickets().size() < flight.getCountSeats()) {
                result.add(flightDto);
            }
        }

        return result;
    }
}

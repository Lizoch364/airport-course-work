package com.example.demo.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Benefit;
import com.example.demo.domain.Flight;
import com.example.demo.domain.Ticket;
import com.example.demo.domain.User;
import com.example.demo.dto.ticket.TicketCreateDto;
import com.example.demo.dto.ticket.TicketDto;
import com.example.demo.repository.FlightRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.BenefitService;
import com.example.demo.services.TicketService;

@Service
public class TicketServiceImpl implements TicketService{
  private TicketRepository ticketRepository;
  private UserRepository userRepository;
  private FlightRepository flightRepository;

  private BenefitService benefitService;

  private ModelMapper modelMapper;

  @Override
  public List<TicketDto> findAll() {
    return ticketRepository.findAll().stream().map(ticket -> {
      var result = modelMapper.map(ticket, TicketDto.class);
      result.setTotalPrice(calculateTotalPrice(ticket));

      return result;
    }
    ).toList();
  }

  @Override
  public TicketDto findById(int id) {
    Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("Билет с id = " + id + " не найден"));

    TicketDto ticketDto = modelMapper.map(ticket, TicketDto.class);
    ticketDto.setTotalPrice(calculateTotalPrice(ticket));

    return ticketDto;
  }

  @Override
  public TicketDto buy(TicketCreateDto ticketCreateDto) {
    User user = userRepository.findByLogin(ticketCreateDto.getPassengerLogin()).orElseThrow(() -> new RuntimeException("Пользователь с login = " + ticketCreateDto.getPassengerLogin() + " не найден"));
    Flight flight = flightRepository.findById(ticketCreateDto.getFlightId()).orElseThrow(() -> new RuntimeException("Рейс с id = " + ticketCreateDto.getFlightId() + " не найден"));

    if (flight.getCountSeats() <= flight.getTickets().size()) {
      throw new RuntimeException("Билеты на этот рейс закончились");
    }

    benefitService.recalculateUserBenefits(user.getId());

    Benefit benefit = benefitService.getMaxBenefit(user.getBenefits());

    Ticket createTicket = new Ticket(user, flight, flight.getPrice(), benefit.getDiscountMultiplier());

    var tickets = flight.getTickets();
    tickets.add(createTicket);
    flight.setTickets(tickets);
    double totalPrice = calculateTotalPrice(createTicket);

    var ticketDto = modelMapper.map(ticketRepository.save(createTicket), TicketDto.class);
    ticketDto.setTotalPrice(totalPrice);

    return ticketDto;
  }

  @Override
  public void decline(int id) {
    Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("Билет с id = " + id + " не найден"));

    ticket.getFlight().getTickets().remove(ticket);
    flightRepository.update(ticket.getFlight());

    ticket.decline();

    ticketRepository.update(ticket);
  }

  @Override
  public List<TicketDto> findAllByUserLogin(String userLogin) {
    var user = userRepository.findByLogin(userLogin).orElseThrow(() -> new RuntimeException("Пользователь с login = " + userLogin + "не найден"));

    return ticketRepository.findAllByUserId(user.getId()).stream().map(ticket -> {
      var a = modelMapper.map(ticket, TicketDto.class);

      a.setTotalPrice(calculateTotalPrice(ticket));

      return a;
    }).toList();
  }

  private double calculateTotalPrice(Ticket ticket) {
    return Math.round(((ticket.getInitialPrice() * (1 - ticket.getDiscount())) * 100.0) / 100.0);
  }

  @Autowired
  public void setTicketRepository(TicketRepository ticketRepository) {
    this.ticketRepository = ticketRepository;
  }

  @Autowired
  public void setUserRepository(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Autowired
  public void setFlightRepository(FlightRepository flightRepository) {
    this.flightRepository = flightRepository;
  }

  @Autowired
  public void setBenefitService(BenefitService benefitService) {
    this.benefitService = benefitService;
  }

  @Autowired
  public void setModelMapper(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }
}

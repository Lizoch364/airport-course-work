package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.ticket.TicketCreateDto;
import com.example.demo.dto.ticket.TicketDto;

public interface TicketService {
  List<TicketDto> findAll();
  TicketDto findById(int id);
  TicketDto buy(TicketCreateDto ticketCreateDto);
  List<TicketDto> findAllByUserLogin(String userLogin);
  void decline(int id);
}

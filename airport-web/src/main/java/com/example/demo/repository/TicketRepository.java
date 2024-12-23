package com.example.demo.repository;

import java.util.List;

import com.example.demo.domain.Ticket;
import com.example.demo.repository.baseRepository.CreateRepository;
import com.example.demo.repository.baseRepository.GetRepository;
import com.example.demo.repository.baseRepository.UpdateRepository;

public interface TicketRepository extends CreateRepository<Ticket>, UpdateRepository<Ticket>, GetRepository<Ticket>{
  int countAllTicketsByAirlineId(int airlineId);
  List<Ticket> findAllByUserId(int userId);
}

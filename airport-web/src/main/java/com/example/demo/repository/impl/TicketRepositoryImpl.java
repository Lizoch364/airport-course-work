package com.example.demo.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.Ticket;
import com.example.demo.repository.TicketRepository;
import com.example.demo.repository.baseRepository.BaseRepositoryImpl;

@Repository
public class TicketRepositoryImpl extends BaseRepositoryImpl<Ticket> implements TicketRepository {
  public TicketRepositoryImpl() {
    super(Ticket.class);
  }
  public int countAllTicketsByAirlineId(int airlineId) {
    return getEntityManager().createQuery("""
        select count(t.id) from Ticket t
        join t.flight f
        join f.airline a
        where a.id = :airlineId and t.ticketStatus != 'Declined'
      """, Long.class)
      .setParameter("airlineId", airlineId)
      .getSingleResult().intValue();
}

  @Override
  public List<Ticket> findAllByUserId(int userId) {
    return getEntityManager().createQuery("select t from Ticket t join User u on t.user = u where u.id = :userId and t.ticketStatus = 'Payed'", Ticket.class)
    .setParameter("userId", userId)
    .getResultList();
  }
}

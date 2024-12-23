package com.example.airport.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.airport.forms.BuyTicketForm;

@RequestMapping("/tickets")
public interface UserTicketsController {
  @GetMapping("/user/{id}")
  String findAllUserTickets(
    @PathVariable("id") int id,
    Model model
  );

  @GetMapping("/{id}")
  String findTicketByID (
    @PathVariable("id") int id,
    Model model
  );

  @DeleteMapping("/{id}/cancel")
  String cancelUserTicket(
    @PathVariable("id") int id,
    Model model
  );

  @GetMapping("/buy")
  String buyTicketPage(
    Model model
  );

  @PostMapping("/buy")
  String buyTicket(
    @ModelAttribute("form") BuyTicketForm form,
    Model model
  );
}

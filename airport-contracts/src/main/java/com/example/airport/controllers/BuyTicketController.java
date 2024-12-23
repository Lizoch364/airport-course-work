package com.example.airport.controllers;

import java.security.Principal;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.airport.forms.BuyTicketForm;

public interface BuyTicketController {

  @GetMapping
  public String getBuyTicketPage(
    @RequestParam(name = "f", required = false) String flightId,
    Principal principal,
    Model model
  );

  @PostMapping
  public String buyTicket(
    @ModelAttribute("form") BuyTicketForm buyTicketForm,
    BindingResult result,
    Principal principal,
    Model model
  );
}

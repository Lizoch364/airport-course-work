package com.example.airport.controllers;

import java.security.Principal;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.airport.forms.SearchFlightForm;


public interface UserContextController {

  @GetMapping("/tickets/{id}")
  public String getTicketById(
    @PathVariable int id,
    Principal principal,
    Model model
  );

  @GetMapping("/tickets")
  public String allTicketsByUserPage(
    Principal principal,
    Model model
  );

  @PostMapping("/tickets/decline/{id}")
  public String decline(@PathVariable int id);

  @GetMapping("/")
  public String findFlightsPage(
    Model model
  );

  @GetMapping("/flights")
  public String findFlightsByDEpartureAndArrivalAirports(
    SearchFlightForm form,
    BindingResult result,
    Model model
  );
}

package com.example.airport.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/rating-airline")
public interface RatingAirlineController {
  @GetMapping("/calculate-rating")
  String getRatingAirline(
    @RequestParam( required = false, defaultValue = "5") String amount,
    Model model
  );
}

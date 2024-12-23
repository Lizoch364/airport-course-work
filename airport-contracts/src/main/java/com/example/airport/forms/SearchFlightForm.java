package com.example.airport.forms;

import jakarta.validation.constraints.NotBlank;

public record SearchFlightForm(
  @NotBlank
  String departureCity,
  @NotBlank
  String arrivalCity)
{}
